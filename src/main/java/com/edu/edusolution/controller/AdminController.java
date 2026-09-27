package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.AdminLogRequestDTO;
import com.edu.edusolution.dto.request.AdminRegisterRequestDTO;
import com.edu.edusolution.dto.response.AdminLogResponse;
import com.edu.edusolution.dto.response.AdminRegisterResponseDTO;
import com.edu.edusolution.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<AdminLogResponse> adminLogin(@RequestBody @Valid AdminLogRequestDTO request) {
        return ResponseEntity.ok(adminService.authenticate(request));
    }

    @PostMapping("/add")
    public ResponseEntity<AdminRegisterResponseDTO> adminRegister(Authentication authentication, @RequestBody @Valid AdminRegisterRequestDTO request) {
        return ResponseEntity.ok(adminService.adminRegister(request));
    }
}
