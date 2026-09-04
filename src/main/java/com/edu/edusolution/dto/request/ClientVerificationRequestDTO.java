package com.edu.edusolution.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientVerificationRequestDTO {

    @NotBlank(message = "email is required")
    @Size(max = 50, message = "email must not exceed 50 characters")
    @Email(message = "email must be a valid email address")
    @JsonProperty("email")
    private String clientEmail;

    @Size(max = 6, message = "Verification code is only 6 characters")
    private String verificationCode;
}
