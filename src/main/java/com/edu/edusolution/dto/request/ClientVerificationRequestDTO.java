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
public class ClientVerificationRequestDTO {

    @NotBlank(message = EMAIL_IS_REQUIRED_MSG)
    @NotNull(message = EMAIL_IS_REQUIRED_MSG)
    @Size(max = 50, message = EMAIL_LENGTH_MSG)
    @Email(message = EMAIL_VALID_MSG)
    @JsonProperty(EMAIL_JSON_FIELD)
    private String clientEmail;

    @Size(max = 6, min = 6, message = CODE_LENGTH_MSG)
    @NotNull(message = CODE_IS_REQUIRED_MSG)
    @NotBlank(message = CODE_IS_REQUIRED_MSG)
    @JsonProperty(CODE_JSON_FIELD)
    private String verificationCode;
}
