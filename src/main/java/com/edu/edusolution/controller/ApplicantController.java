package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.ApplicantCommentAddingRequestDTO;
import com.edu.edusolution.dto.response.ApplicantCommentAddingResponseDTO;
import com.edu.edusolution.dto.response.ApplicantCommentResponseDTO;
import com.edu.edusolution.service.ApplicantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applicant")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping("/top_comments")
    public ResponseEntity<List<ApplicantCommentResponseDTO>> getTopApplicantComments(){
        return ResponseEntity.ok(applicantService.getTopApplicantComments());
    }

    @PostMapping("/add")
    public ResponseEntity<ApplicantCommentAddingResponseDTO> addApplicantComment(@RequestBody @Valid ApplicantCommentAddingRequestDTO request){
        return ResponseEntity.ok(applicantService.addApplicantComment(request));
    }
}
