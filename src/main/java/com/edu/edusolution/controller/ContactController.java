package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.CreateContactRequestDTO;
import com.edu.edusolution.dto.response.CreateContactResponseDTO;
import com.edu.edusolution.service.ContactService;
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
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<CreateContactResponseDTO> createContact(@RequestBody @Valid CreateContactRequestDTO request) {
        return ResponseEntity.ok(contactService.createContact(request));
    }
}
