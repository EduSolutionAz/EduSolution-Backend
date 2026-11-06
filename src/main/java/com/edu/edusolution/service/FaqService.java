package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.FaqAddRequestDTO;
import com.edu.edusolution.dto.request.FaqDeleteRequestDTO;
import com.edu.edusolution.dto.request.FaqUpdateRequestDTO;
import com.edu.edusolution.dto.response.FaqAddResponseDTO;
import com.edu.edusolution.dto.response.FaqDeleteResponseDTO;
import com.edu.edusolution.dto.response.FaqResponseDTO;
import com.edu.edusolution.dto.response.FaqUpdateResponseDTO;
import com.edu.edusolution.entity.faq.FaqEntity;
import com.edu.edusolution.exception.FaqNotFoundException;
import com.edu.edusolution.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public FaqAddResponseDTO createFaq(FaqAddRequestDTO request) {

        FaqEntity faq = new FaqEntity();
        faq.setFaqQuestion(request.getFaqQuestion());
        faq.setFaqAnswer(request.getFaqText());

        faqRepository.save(faq);

        return FaqAddResponseDTO
                .builder()
                .faqId(faq.getFaqId())
                .isCreated(true)
                .build();

    }

    public FaqDeleteResponseDTO deleteFaq(FaqDeleteRequestDTO request) {
        FaqEntity checkFaq = faqRepository.findByFaqId(request.getFaqId())
                .orElseThrow(FaqNotFoundException::new);

        faqRepository.delete(checkFaq);

        return FaqDeleteResponseDTO
                .builder()
                .isDeleted(true)
                .build();
    }

    public List<FaqResponseDTO> allFaqs() {
        List<FaqEntity> faqs = faqRepository.findAll();

        return faqs.stream()
                .map(
                        faqEntity -> FaqResponseDTO
                                .builder()
                                .faqAnswer(faqEntity.getFaqAnswer())
                                .faqQuestion(faqEntity.getFaqQuestion())
                                .faqId(faqEntity.getFaqId())
                                .build()
                ).toList();
    }

    public FaqUpdateResponseDTO updateFaq(FaqUpdateRequestDTO request) {
        FaqEntity faq = faqRepository.findByFaqId(request.getFaqId())
                .orElseThrow(FaqNotFoundException::new);

        faq.setFaqAnswer(request.getFaqAnswer());
        faq.setFaqQuestion(request.getFaqQuestion());

        faqRepository.save(faq);

        return FaqUpdateResponseDTO
                .builder()
                .faqId(request.getFaqId())
                .isUpdated(true)
                .build();
    }





}
