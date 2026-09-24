package com.edu.edusolution.service;

import com.edu.edusolution.dto.ErrorDto;
import com.edu.edusolution.dto.request.GenerateCommentLinkRequestDTO;
import com.edu.edusolution.dto.request.SendReviewRequestDTO;
import com.edu.edusolution.dto.response.GenerateCommentLinkResponseDTO;
import com.edu.edusolution.dto.response.SendReviewResponseDTO;
import com.edu.edusolution.entity.applicant.ApplicantEntity;
import com.edu.edusolution.entity.applicant.ApplicantGenerationEntity;
import com.edu.edusolution.exception.TokenNotFoundException;
import com.edu.edusolution.repository.ApplicantGenerationRepository;
import com.edu.edusolution.repository.ApplicantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import java.util.HexFormat;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicantGenerateService {

    private final ApplicantGenerationRepository applicantGenerationRepository;
    private final MailService mailService;
    private final ApplicantRepository applicantRepository;

    public GenerateCommentLinkResponseDTO generateLink(GenerateCommentLinkRequestDTO request) {
        String newGen = UUID.randomUUID().toString().toLowerCase();
        String hash = hashToken(newGen);

        final String frontLink = "edusolution.az/comment/"+newGen;
        mailService.sendPlainText(request.getEmail(),"Send your thoughts about us", "Your comments are valuable for us. click the link below and write your thoughts about us \n"+frontLink);

        ApplicantGenerationEntity newAppGen = new ApplicantGenerationEntity();
        newAppGen.setClientEmail(request.getEmail());
        newAppGen.setClientName(request.getName());
        newAppGen.setUsed(false);
        newAppGen.setExpiresAt(OffsetDateTime.now().plusHours(2));
        newAppGen.setTokenHash(hash);

        applicantGenerationRepository.save(newAppGen);

        return GenerateCommentLinkResponseDTO
                .builder()
                .email(request.getEmail())
                .isSent(true)
                .build();
    }

    @Transactional
    public SendReviewResponseDTO sendReview(SendReviewRequestDTO request) {

        final String TOKEN_EXPIRED = "Token has expired, request a new token";
        final String TOKEN_USED = "Token is already used";

        String hash = hashToken(request.getToken());
        ApplicantGenerationEntity entity = applicantGenerationRepository.findByTokenHash(hash)
                .orElseThrow(TokenNotFoundException::new);

        if(entity.getExpiresAt().isBefore(OffsetDateTime.now())) {
            return SendReviewResponseDTO
                    .builder()
                    .isCommentAccepted(false)
                    .errors(
                            List.of(
                                    new ErrorDto(TOKEN_EXPIRED)
                            )
                    )
                    .build();
        }

        if(entity.isUsed()){
            return SendReviewResponseDTO
                    .builder()
                    .email(entity.getClientEmail())
                    .isCommentAccepted(false)
                    .errors(
                            List.of(
                                    new ErrorDto(TOKEN_USED)
                            )
                    )
                    .build();
        }

        ApplicantEntity applicant = new ApplicantEntity();
        applicant.setApplicantName(entity.getClientName());
        applicant.setComment(request.getComment());
        applicant.setApplicantServiceType(request.getService());
        applicant.setApplicantEmail(entity.getClientEmail());

        entity.setUsed(true);

        applicantRepository.save(applicant);
        applicantGenerationRepository.save(entity);

        return SendReviewResponseDTO
                .builder()
                .errors(List.of())
                .email(entity.getClientEmail())
                .isCommentAccepted(true)
                .build();

    }

    private String hashToken(String rawToken){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(
                    rawToken.getBytes(StandardCharsets.UTF_8)
            );

            return HexFormat.of().formatHex(hash);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }
}
