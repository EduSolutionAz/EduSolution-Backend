package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class ClientRegisterRequestDTO {

    @NotBlank(message = "email is required")
    @NotNull(message = "email is required")
    @Size(max = 50, message = "email must not exceed 50 characters")
    @Email(message = "email must be a valid email address")
    @JsonProperty("email")
    private String clientEmail;

    @NotBlank(message = "name is required")
    @NotNull(message = "name is required")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    @JsonProperty("name")
    private String clientName;

    @NotBlank(message = "phone is required")
    @NotNull(message = "phone is required")
    @Size(max = 15, message = "phone number must not exceed 10 characters")
    @JsonProperty("phone")
    private String clientPhone;
}
