package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.FaqAddRequestDTO;
import com.edu.edusolution.dto.request.FaqDeleteRequestDTO;
import com.edu.edusolution.dto.request.FaqUpdateRequestDTO;
import com.edu.edusolution.dto.response.FaqAddResponseDTO;
import com.edu.edusolution.dto.response.FaqDeleteResponseDTO;
import com.edu.edusolution.dto.response.FaqResponseDTO;
import com.edu.edusolution.dto.response.FaqUpdateResponseDTO;
import com.edu.edusolution.service.FaqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faq")
@RequiredArgsConstructor
public class FaqController {
    private final FaqService faqService;

    @Operation(
            summary = "Create a new FAQ",
            description = "Creates a new frequently asked question and stores it on the platform."
    )
    @ApiResponse(
            responseCode = "201",
            description = "FAQ created successfully",
            content = @Content(
                    schema = @Schema(implementation = FaqAddResponseDTO.class)
            )
    )
    @PostMapping("/create")
    public ResponseEntity<FaqAddResponseDTO> createFaq(@RequestBody @Valid FaqAddRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(faqService.createFaq(request));
    }

    @Operation(
            summary = "Delete an FAQ",
            description = "Deletes an existing frequently asked question from the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "FAQ deleted successfully",
            content = @Content(
                    schema = @Schema(implementation = FaqDeleteResponseDTO.class)
            )
    )
    @DeleteMapping("/delete")
    public ResponseEntity<FaqDeleteResponseDTO> deleteFaq(@RequestBody @Valid FaqDeleteRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(faqService.deleteFaq(request));
    }

    @Operation(
            summary = "Update an FAQ",
            description = "Updates the information of an existing frequently asked question."
    )
    @ApiResponse(
            responseCode = "200",
            description = "FAQ updated successfully",
            content = @Content(
                    schema = @Schema(implementation = FaqUpdateResponseDTO.class)
            )
    )
    @PatchMapping("/update")
    public ResponseEntity<FaqUpdateResponseDTO> updateFaq(@RequestBody @Valid FaqUpdateRequestDTO request) {
        return ResponseEntity.ok(faqService.updateFaq(request));
    }

    @Operation(
            summary = "Get all FAQs",
            description = "Retrieves a list of all frequently asked questions available on the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "FAQs retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = FaqResponseDTO.class)
                    )
            )
    )
    @GetMapping("/all")
    public ResponseEntity<List<FaqResponseDTO>> getAllFaqs(){
        return ResponseEntity.ok(faqService.allFaqs());
    }
}
