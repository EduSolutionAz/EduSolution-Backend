package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.CreateContactRequestDTO;
import com.edu.edusolution.dto.response.CreateContactResponseDTO;
import com.edu.edusolution.service.ContactService;
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
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
@Tag(name = "Contact Operations", description = "API(s) for contact operation")
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/add")
    @Operation(
            summary = "Create a contact request",
            description = "Creates a new contact request submitted by a user."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Contact request created successfully",
            content = @Content(
                    schema = @Schema(implementation = CreateContactResponseDTO.class)
            )
    )
    public ResponseEntity<CreateContactResponseDTO> createContact(@RequestBody @Valid CreateContactRequestDTO request) {
        return ResponseEntity.ok(contactService.createContact(request));
    }
}
