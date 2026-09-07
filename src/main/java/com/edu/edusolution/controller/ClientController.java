package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.ClientPasswordCreationRequestDTO;
import com.edu.edusolution.dto.request.ClientRegisterRequestDTO;
import com.edu.edusolution.dto.request.ClientVerificationRequestDTO;
import com.edu.edusolution.dto.request.LoginRequest;
import com.edu.edusolution.dto.response.ClientPasswordCreationResponseDTO;
import com.edu.edusolution.dto.response.ClientRegisterResponseDTO;
import com.edu.edusolution.dto.response.ClientVerificationResponseDTO;
import com.edu.edusolution.dto.response.LoginResponse;
import com.edu.edusolution.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<ClientRegisterResponseDTO> clientRegister(@Valid @RequestBody ClientRegisterRequestDTO request){
        return ResponseEntity.ok(clientService.clientRegister(request));
    }

    @PostMapping("/register/verify")
    public ResponseEntity<ClientVerificationResponseDTO> clientVerify(@Valid @RequestBody ClientVerificationRequestDTO request){
        return ResponseEntity.ok(clientService.clientVerify(request));
    }

    @PostMapping("/register/password")
    public ResponseEntity<ClientPasswordCreationResponseDTO> clientPasswordCreation(@Valid @RequestBody ClientPasswordCreationRequestDTO request){
        return ResponseEntity.ok(clientService.clientCreation(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> clientLogin(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(clientService.authenticate(request));
    }

}
