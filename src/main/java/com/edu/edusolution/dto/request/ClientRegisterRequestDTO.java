package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;
import static com.edu.edusolution.constants.DtoConstants.EMAIL_JSON_FIELD;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterRequestDTO {

    @NotBlank(message = EMAIL_IS_REQUIRED_MSG)
    @NotNull(message = EMAIL_IS_REQUIRED_MSG)
    @Size(max = 50, message = EMAIL_LENGTH_MSG)
    @Email(message = EMAIL_VALID_MSG)
    @JsonProperty(EMAIL_JSON_FIELD)
    private String clientEmail;

    @NotBlank(message = NAME_IS_REQUIRED_MSG)
    @NotNull(message = NAME_IS_REQUIRED_MSG)
    @Size(max = 50, message = NAME_LENGTH_MSG)
    @JsonProperty(NAME_JSON_FIELD)
    private String clientName;

    @NotBlank(message = PHONE_IS_REQUIRED_MSG)
    @NotNull(message = PHONE_IS_REQUIRED_MSG)
    @Size(max = 15, min = 12, message = PHONE_LENGTH_MSG)
    @JsonProperty(PHONE_JSON_FIELD)
    private String clientPhone;
}
