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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientPasswordCreationRequestDTO {

    @NotBlank(message = EMAIL_IS_REQUIRED_MSG)
    @NotNull(message = EMAIL_IS_REQUIRED_MSG)
    @Size(max = 50, message = EMAIL_LENGTH_MSG)
    @Email(message = EMAIL_VALID_MSG)
    @JsonProperty(EMAIL_JSON_FIELD)
    private String clientEmail;

    @Size(min = 9, max = 20, message = PASSWORD_LENGTH_MSG)
    @JsonProperty(PASSWORD_JSON_FIELD)
    @NotNull(message = PASSWORD_IS_REQUIRED_MSG)
    @NotBlank(message = PASSWORD_IS_REQUIRED_MSG)
    private String clientPassword;
}
