package com.edu.edusolution.dto.request;

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
public class DeleteCommentRequestDTO {

    @NotNull(message = NAME_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = NAME_IS_REQUIRED_BLANK_MSG)
    @Size(max = 50, message = NAME_LENGTH_MSG)
    String name;
    @NotNull(message = COMMENT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COMMENT_IS_REQUIRED_BLANK_MSG)
    @Size(min = 10, max = 256, message = COMMENT_SIZE_MSG)
    String comment;
}
