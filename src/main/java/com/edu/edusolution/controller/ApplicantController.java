package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.ApplicantCommentAddingRequestDTO;
import com.edu.edusolution.dto.request.DeleteCommentRequestDTO;
import com.edu.edusolution.dto.response.ApplicantCommentAddingResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentsResponseDTO;
import com.edu.edusolution.dto.response.DeleteCommentResponseDTO;
import com.edu.edusolution.service.ApplicantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applicant")
@RequiredArgsConstructor
@Tag(name = "Applicant Operations", description = "API(s) for applicant operation")
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping("/top_comments")
    @Operation(
            summary = "Get top applicant comments",
            description = "Retrieves a list of top applicant comments displayed on the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Applicant comments retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = ApplicantCommentResponseDTO.class)
                    )
            )
    )
    public ResponseEntity<List<ApplicantCommentResponseDTO>> getTopApplicantComments(){
        return ResponseEntity.ok(applicantService.getTopApplicantComments());
    }

    @PostMapping("/add")
    @Operation(
            summary = "Add an applicant comment",
            description = "Creates a new applicant comment for the authenticated user."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Applicant comment added successfully",
            content = @Content(
                    schema = @Schema(implementation = ApplicantCommentAddingResponseDTO.class)
            )
    )
    public ResponseEntity<ApplicantCommentAddingResponseDTO> addApplicantComment(Authentication authentication, @RequestBody @Valid ApplicantCommentAddingRequestDTO request) {
        return ResponseEntity.ok(applicantService.addApplicantComment(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ApplicantCommentsResponseDTO>> getAllComments() {
        return ResponseEntity.ok(applicantService.getComments());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCommentResponseDTO> deleteComment(@RequestBody @Valid DeleteCommentRequestDTO request) {
        return ResponseEntity.ok(applicantService.deleteComment(request));
    }
}
