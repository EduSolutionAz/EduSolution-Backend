package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequest {
    @NotBlank(message = "email is required")
    @NotNull(message = "email cannot be null")
    @Size(max = 50, message = "email must not exceed 50 characters")
    @Email(message = "email must be a valid email address")
    @JsonProperty("email")
    String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password cannot be null")
    @Size(max = 18, message = "password must not exceed 18 characters")
    @JsonProperty("password")
    String password;
}
