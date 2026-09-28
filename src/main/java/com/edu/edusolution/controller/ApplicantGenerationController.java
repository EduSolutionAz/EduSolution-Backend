package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.GenerateCommentLinkRequestDTO;
import com.edu.edusolution.dto.request.SendReviewRequestDTO;
import com.edu.edusolution.dto.response.GenerateCommentLinkResponseDTO;
import com.edu.edusolution.dto.response.SendReviewResponseDTO;
import com.edu.edusolution.service.ApplicantGenerateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Applicant Operations", description = "API(s) for applicant operation")
public class ApplicantGenerationController {
    private final ApplicantGenerateService applicantGenerateService;

    @PostMapping("/generate")
    @Operation(
            summary = "Generate a comment link",
            description = "Generates a unique link that allows an applicant to submit a review or comment."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Comment link generated successfully",
            content = @Content(
                    schema = @Schema(implementation = GenerateCommentLinkResponseDTO.class)
            )
    )
    public ResponseEntity<GenerateCommentLinkResponseDTO> generateLink(@RequestBody @Valid GenerateCommentLinkRequestDTO request) {
        return ResponseEntity.ok(applicantGenerateService.generateLink(request));
    }

    @PostMapping("/review")
    @Operation(
            summary = "Submit a review",
            description = "Submits a review or comment using a previously generated applicant comment link."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Review submitted successfully",
            content = @Content(
                    schema = @Schema(implementation = SendReviewResponseDTO.class)
            )
    )
    public ResponseEntity<SendReviewResponseDTO> sendReview(@RequestBody @Valid SendReviewRequestDTO request) {
        return ResponseEntity.ok(applicantGenerateService.sendReview(request));
    }
}
