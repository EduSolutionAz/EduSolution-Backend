package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.ApplicantCommentAddingRequestDTO;
import com.edu.edusolution.dto.response.ApplicantCommentAddingResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentResponseDTO;
import com.edu.edusolution.entity.applicant.ApplicantEntity;
import com.edu.edusolution.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public List<ApplicantCommentResponseDTO> getTopApplicantComments() {
        List<ApplicantEntity> applicantEntities = applicantRepository.findTop5ByOrderByCreatedAtDesc();

        List<ApplicantCommentResponseDTO> response =
                applicantEntities
                        .stream()
                        .map(
                                applicantEntity -> ApplicantCommentResponseDTO
                                .builder()
                                .applicantName(applicantEntity.getApplicantName())
                                .comment(applicantEntity.getComment())
                                .service(applicantEntity.getApplicantServiceType())
                                .build()
                        ).toList();


        return response;
    }

    public ApplicantCommentAddingResponseDTO addApplicantComment(ApplicantCommentAddingRequestDTO request) {
        ApplicantEntity newApplicant = new ApplicantEntity();
        newApplicant.setApplicantServiceType(request.getService());
        newApplicant.setApplicantName(request.getName());
        newApplicant.setComment(request.getComment());

        applicantRepository.save(newApplicant);

        return ApplicantCommentAddingResponseDTO
                .builder()
                .isAdded(true)
                .name(request.getName())
                .build();
    }
}
