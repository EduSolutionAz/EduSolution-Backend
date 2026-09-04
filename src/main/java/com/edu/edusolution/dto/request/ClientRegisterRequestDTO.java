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
public class ClientRegisterRequestDTO {

    @NotBlank(message = "email is required")
    @Size(max = 50, message = "email must not exceed 50 characters")
    @Email(message = "email must be a valid email address")
    @JsonProperty("client_email")
    private String clientEmail;

    @Size(max = 50, message = "Name must not exceed 50 characters")
    @JsonProperty("client_name")
    private String clientName;

    @Size(max = 15, message = "phone number must not exceed 10 characters")
    @JsonProperty("phone_number")
    private String clientPhone;
}
