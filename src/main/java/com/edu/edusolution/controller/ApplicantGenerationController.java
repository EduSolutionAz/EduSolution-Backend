package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.GenerateCommentLinkRequestDTO;
import com.edu.edusolution.dto.request.SendReviewRequestDTO;
import com.edu.edusolution.dto.response.GenerateCommentLinkResponseDTO;
import com.edu.edusolution.dto.response.SendReviewResponseDTO;
import com.edu.edusolution.service.ApplicantGenerateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/applicant")
@RequiredArgsConstructor
public class ApplicantGenerationController {
    private final ApplicantGenerateService applicantGenerateService;

    @PostMapping("/generate")
    public ResponseEntity<GenerateCommentLinkResponseDTO> generateLink(@RequestBody @Valid GenerateCommentLinkRequestDTO request) {
        return ResponseEntity.ok(applicantGenerateService.generateLink(request));
    }

    @PostMapping("/review")
    public ResponseEntity<SendReviewResponseDTO> sendReview(@RequestBody @Valid SendReviewRequestDTO request) {
        return ResponseEntity.ok(applicantGenerateService.sendReview(request));
    }
}
