package com.edu.edusolution.dto.request;

import com.edu.edusolution.entity.applicant.ApplicantServices;
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
public class SendReviewRequestDTO {

    @Size(max = 36,min = 36, message = TOKEN_LENGTH_MSG)
    @NotNull(message = TOKEN_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = TOKEN_IS_REQUIRED_BLANK_MSG)
    private String token;

    @NotBlank(message = SERVICE_IS_REQUIRED_BLANK_MSG)
    @NotNull(message = SERVICE_IS_REQUIRED_NULL_MSG)
    private ApplicantServices service;

    @NotNull(message = COMMENT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COMMENT_IS_REQUIRED_BLANK_MSG)
    @Size(message = COMMENT_SIZE_MSG, min = 20, max = 256)
    private String comment;
}
