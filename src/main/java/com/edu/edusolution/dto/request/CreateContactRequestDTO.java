package com.edu.edusolution.dto.request;

import com.edu.edusolution.entity.applicant.ApplicantServices;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;
import static com.edu.edusolution.constants.DtoConstants.NAME_JSON_FIELD;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateContactRequestDTO {

    @NotBlank(message = NAME_IS_REQUIRED_MSG)
    @NotNull(message = NAME_IS_REQUIRED_MSG)
    @Size(max = 100, message = NAME_FULL_LENGTH_MSG)
    @JsonProperty(NAME_JSON_FIELD)
    private String name;

    @NotBlank(message = PHONE_IS_REQUIRED_MSG)
    @NotNull(message = PHONE_IS_REQUIRED_MSG)
    @Size(max = 15, min = 9, message = PHONE_LENGTH_MSG)
    @JsonProperty(PHONE_JSON_FIELD)
    private String phone;

    @NotNull(message = SERVICE_IS_REQUIRED_NULL_MSG)
    @JsonProperty("service")
    private ApplicantServices service;
}
