package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.spin.*;
import com.edu.edusolution.dto.response.spin.*;
import com.edu.edusolution.entity.spin.SpinParticipantEntity;
import com.edu.edusolution.entity.spin.SpinPrizeEntity;
import com.edu.edusolution.entity.spin.SpinResultEntity;
import com.edu.edusolution.exception.*;
import com.edu.edusolution.repository.SpinParticipantRepository;
import com.edu.edusolution.repository.SpinPrizeRepository;
import com.edu.edusolution.repository.SpinResultRepository;
import io.github.bucket4j.Bandwidth;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.github.bucket4j.Bucket;


import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
public class SpinService {

    private final SpinPrizeRepository spinPrizeRepository;
    private final SpinParticipantRepository spinParticipantRepository;
    private final SpinResultRepository spinResultRepository;
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
    private final MailService mailService;


    public PrizeAddResponseDTO addPrizeToSpin(PrizeAddRequestDTO request) {
        Optional<SpinPrizeEntity> checkPrize = spinPrizeRepository.findBySpinPrizeNameIgnoreCase(request.getPrizeName());

        if (checkPrize.isPresent()) {
            throw new PrizeAlreadyExistsException();
        }

        canAddPrize(request.getPrizeWeight());

        SpinPrizeEntity spinPrize = new SpinPrizeEntity();
        spinPrize.setSpinPrizeName(request.getPrizeName());
        spinPrize.setSpinPrizeWeight(request.getPrizeWeight());


        spinPrizeRepository.save(spinPrize);

        return PrizeAddResponseDTO
                .builder()
                .prizeName(request.getPrizeName())
                .isAdded(true)
                .errors(List.of())
                .build();
    }

    public List<PrizesResponseDTO> getPrizes() {

        List<SpinPrizeEntity> prizes = spinPrizeRepository.findAll();

        return prizes
                .stream()
                .map(prizeEntity ->
                        new PrizesResponseDTO(prizeEntity.getSpinPrizeName(), prizeEntity.getSpinPrizeWeight())
                ).toList();
    }

    public PrizeDeleteResponseDTO deletePrize(String prizeName) {

        SpinPrizeEntity spinPrize = spinPrizeRepository.findBySpinPrizeNameIgnoreCase(prizeName)
                .orElseThrow(PrizeNotFoundException::new);

        spinPrizeRepository.delete(spinPrize);

        return PrizeDeleteResponseDTO
                .builder()
                .isDeleted(true)
                .prizeName(prizeName)
                .build();
    }

    @Transactional
    public List<PrizeUpdateResponseDTO> updatePrizes(List<PrizeUpdateRequestDTO> request) {
        List<PrizeUpdateResponseDTO> response = new ArrayList<>();

        List<SpinPrizeEntity> prizes = spinPrizeRepository.findAll();

        Map<String, SpinPrizeEntity> prizeMap = prizes.stream()
                .collect(Collectors.toMap(
                        prize -> prize.getSpinPrizeName().toLowerCase(),
                        Function.identity()
                ));


        for (PrizeUpdateRequestDTO dto : request) {
            SpinPrizeEntity prize = prizeMap.get(
                    dto.getPrizeName().toLowerCase()
            );

            if (prize == null) {
                throw new PrizeNotFoundException();
            }

            prize.setSpinPrizeWeight(dto.getPrizeWeight());


            response.add(
                    new PrizeUpdateResponseDTO(
                            prize.getSpinPrizeName(),
                            prize.getSpinPrizeWeight()
                    )
            );
        }

        int totalWeight = 0;
        for (Map.Entry<String, SpinPrizeEntity> entry : prizeMap.entrySet()) {
            totalWeight += entry.getValue().getSpinPrizeWeight();
        }
        canUpdatePrize(totalWeight);

        spinPrizeRepository.saveAll(prizes);

        return response;
    }

    public SpinCheckResponseDTO spinEligibilityCheck(SpinCheckRequestDTO request) {

        Bucket bucket = buckets.computeIfAbsent(
                request.getIp(),
                key -> createBucket()
        );

        if (!bucket.tryConsume(1)) {
            throw new TooManyRequestsException(TOO_MANY_REQUEST_GAME_MSG);
        }

        SpinParticipantEntity spinParticipant = spinParticipantRepository.findByBrowserId(request.getBrowserId())
                .orElseGet(() -> createParticipant(request));

        spinParticipant.setIp(request.getIp());
        spinParticipantRepository.save(spinParticipant);

        checkPlayer(spinParticipant);

        return SpinCheckResponseDTO
                .builder()
                .canPlay(true)
                .build();
    }

    @Transactional
    public SpinPrizeResponseDTO playSpin(SpinPlayRequestDTO request) {

        List<SpinPrizeEntity> prizes = spinPrizeRepository.findAll();
        SpinPrizeEntity prize = getPrize(prizes);

        SpinParticipantEntity participant = spinParticipantRepository.findByBrowserId(request.getBrowserId())
                .orElseThrow(() -> new ParticipantNotFoundException(PARTICIPANT_NOT_FOUND_MSG));

        checkPlayer(participant);

        SpinResultEntity spinResultEntity = new SpinResultEntity();
        spinResultEntity.setParticipant(participant);
        spinResultEntity.setPrize(prize);
        spinResultEntity.setRewardId(UUID.randomUUID());

        spinResultRepository.save(spinResultEntity);


        return SpinPrizeResponseDTO
                .builder()
                .prize(prize.getSpinPrizeName())
                .build();
    }

    @Transactional
    public PrizeSendResponseDTO sendPrize(PrizeSendRequestDTO request) {

        final String MAIL_SUBJECT = "Your Prize from EduSolution Academy🚀";

        SpinParticipantEntity participant = spinParticipantRepository.findByBrowserId(request.getBrowserId())
                .orElseThrow(() -> new ParticipantNotFoundException(PARTICIPANT_NOT_FOUND_MSG));
        SpinResultEntity spinResult = spinResultRepository.findTopByParticipantOrderByCreatedAtDesc(participant)
                .orElseThrow(() -> new ResultNotFoundException(RESULT_NOT_FOUND_MSG));

        checkPlayer(participant);

        UUID reward = UUID.randomUUID();

        spinResult.setEmail(request.getEmail());
        spinResult.setRewardId(reward);

        mailService.sendPlainText(request.getEmail(), MAIL_SUBJECT, prizeBody(reward));

        return PrizeSendResponseDTO
                .builder()
                .isSent(true)
                .build();
    }

    public List<SpinWinnersDTO> spinWinners() {
        List<SpinResultEntity> results = spinResultRepository.findAllByOrderByCreatedAtDesc();

        return results.stream()
                .map(
                        spinResultEntity ->
                                SpinWinnersDTO
                                        .builder()
                                        .email(spinResultEntity.getEmail())
                                        .prizeId(spinResultEntity.getRewardId())
                                        .prize(spinResultEntity.getPrize().getSpinPrizeName())
                                        .build()
                ).toList();
    }

    private SpinParticipantEntity createParticipant(SpinCheckRequestDTO request) {

        return SpinParticipantEntity
                .builder()
                .ip(request.getIp())
                .browserId(request.getBrowserId())
                .build();
    }

    private void checkPlayer(SpinParticipantEntity participant) {
        Optional<SpinResultEntity> lastResult =
                spinResultRepository.findTopByParticipantOrderByCreatedAtDesc(participant);

        if (lastResult.isPresent()
                && OffsetDateTime.now().isBefore(
                lastResult.get().getCreatedAt().plusMonths(6)
        )) {

            throw new SpinGamePlayException(
                    SPIN_PLAY_WAIT_MSG
            );
        }
    }

    private SpinPrizeEntity getPrize(List<SpinPrizeEntity> prizes) {
        int totalWeight = prizes.stream()
                .mapToInt(SpinPrizeEntity::getSpinPrizeWeight)
                .sum();

        if (totalWeight <= 0) {
            throw new SpinGamePlayException(SPIN_PLAY_WEIGHT_ZERO_MSG);
        } else if (totalWeight > 100) {
            throw new SpinGamePlayException(SPIN_PLAY_WEIGHT_HUNDRED_MSG);
        }

        int random = ThreadLocalRandom.current()
                .nextInt(totalWeight);

        int cumulativeWeight = 0;

        for (SpinPrizeEntity prize : prizes) {
            cumulativeWeight += prize.getSpinPrizeWeight();

            if (random < cumulativeWeight) {
                return prize;
            }
        }

        throw new IllegalStateException("Could not select prize");
    }

    private Bucket createBucket() {
        Bandwidth limit = Bandwidth.builder()
                .capacity(5)
                .refillGreedy(5, Duration.ofMinutes(1))
                .build();

        return Bucket.builder()
                .addLimit(limit)
                .build();
    }

    private void canAddPrize(int weight) {
        List<SpinPrizeEntity> prizes = spinPrizeRepository.findAll();
        int sum = 0;
        for (SpinPrizeEntity prize : prizes) {
            sum += prize.getSpinPrizeWeight();
        }
        if ((sum + weight) > 100) {
            throw new TotalWeightException(TOTAL_WEIGHT_MSG + (sum));
        }
    }

    private void canUpdatePrize(int weight) {
        if (weight > 100) {
            throw new TotalWeightException(TOTAL_WEIGHT_MSG + (weight));
        }
    }

    private String prizeBody(UUID code) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Your EduSolution Academy Prize</title>
                </head>
                <body>
                    <h1>Congratulations! 🎉</h1>
                
                    <p>You have won a prize from <strong>EduSolution Academy</strong>.</p>
                
                    <p>Your prize:</p>
                
                    <h2>20%% Visa Consultation Discount</h2>
                
                    <p>Your redemption code:</p>
                
                    <h2>%s</h2>
                
                    <p>
                        Contact us on WhatsApp and provide this code
                        to claim your prize.
                    </p>
                
                    <p>
                        Thank you for participating!
                    </p>
                </body>
                </html>
                """.formatted(code);
    }


}
