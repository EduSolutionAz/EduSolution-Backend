package com.edu.edusolution.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRegisterRequestDTO {

    @Size(max = 20, message = USERNAME_LENGTH_MSG)
    private String username;

    @Size(min = 9, max = 20, message = PASSWORD_LENGTH_MSG)
    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_MSG)
    private String password;

    @Email(message = EMAIL_VALID_MSG)
    @Size(max = 75, message = EMAIL_LENGTH_MSG)
    @NotNull(message = EMAIL_IS_REQUIRED_MSG)
    @NotBlank(message = EMAIL_IS_REQUIRED_MSG)
    private String email;
}
