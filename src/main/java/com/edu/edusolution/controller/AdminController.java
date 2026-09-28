package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.AdminLogRequestDTO;
import com.edu.edusolution.dto.request.AdminRegisterRequestDTO;
import com.edu.edusolution.dto.response.AdminLogResponse;
import com.edu.edusolution.dto.response.AdminRegisterResponseDTO;
import com.edu.edusolution.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Admin Operations", description = "API(s) for admin operation")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    @Operation(
            summary = "Admin login",
            description = "Authenticates an administrator using their credentials and returns an authentication response."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Administrator authenticated successfully",
            content = @Content(
                    schema = @Schema(implementation = AdminLogResponse.class)
            )
    )
    public ResponseEntity<AdminLogResponse> adminLogin(@RequestBody @Valid AdminLogRequestDTO request) {
        return ResponseEntity.ok(adminService.authenticate(request));
    }

    @PostMapping("/add")
    @Operation(
            summary = "Register a new admin",
            description = "Creates a new administrator account. This operation requires authentication."
    )
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponse(
            responseCode = "200",
            description = "Administrator registered successfully",
            content = @Content(
                    schema = @Schema(implementation = AdminRegisterResponseDTO.class)
            )
    )
    public ResponseEntity<AdminRegisterResponseDTO> adminRegister(Authentication authentication, @RequestBody @Valid AdminRegisterRequestDTO request) {
        return ResponseEntity.ok(adminService.adminRegister(request));
    }
}
