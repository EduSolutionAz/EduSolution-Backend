package com.edu.edusolution.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenerateCommentLinkRequestDTO {
    @NotNull(message = NAME_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = NAME_IS_REQUIRED_BLANK_MSG)
    @Size(message = NAME_FULL_LENGTH_MSG)
    private String name;
    @NotBlank(message = EMAIL_IS_REQUIRED_MSG)
    @NotNull(message = EMAIL_IS_REQUIRED_MSG)
    @Email(message = EMAIL_VALID_MSG)
    private String email;
}
