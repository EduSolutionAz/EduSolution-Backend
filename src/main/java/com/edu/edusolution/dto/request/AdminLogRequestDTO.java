package com.edu.edusolution.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminLogRequestDTO {
    @Size(max = 20, message = USERNAME_LENGTH_MSG)
    private String username;
    @Size(min = 9, max = 30, message = PASSWORD_LENGTH_MSG)
    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_MSG)
    private String password;
}
