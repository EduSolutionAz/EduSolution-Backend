package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.ApplicantCommentAddingRequestDTO;
import com.edu.edusolution.dto.request.DeleteCommentRequestDTO;
import com.edu.edusolution.dto.response.ApplicantCommentAddingResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentsResponseDTO;
import com.edu.edusolution.dto.response.DeleteCommentResponseDTO;
import com.edu.edusolution.entity.applicant.ApplicantEntity;
import com.edu.edusolution.exception.ApplicantNotFoundException;
import com.edu.edusolution.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    public List<ApplicantCommentsResponseDTO> getComments(){
        List<ApplicantEntity> applicants = applicantRepository.findAll();

        return applicants
                .stream()
                .map(applicantEntity -> ApplicantCommentsResponseDTO
                .builder()
                .name(applicantEntity.getApplicantName())
                .comment(applicantEntity.getComment())
                .build()
        )
                .toList();
    }

    public DeleteCommentResponseDTO deleteComment(DeleteCommentRequestDTO request) {
        ApplicantEntity applicant = applicantRepository.findByApplicantNameAndComment(request.getName(), request.getComment())
                .orElseThrow(ApplicantNotFoundException::new);

        applicantRepository.delete(applicant);
        log.info("Comment deletion happened");

        return DeleteCommentResponseDTO
                .builder()
                .isDeleted(true)
                .build();
    }
}
