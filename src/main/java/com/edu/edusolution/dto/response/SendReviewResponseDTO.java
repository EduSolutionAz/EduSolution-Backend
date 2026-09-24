package com.edu.edusolution.dto.response;

import com.edu.edusolution.dto.ErrorDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendReviewResponseDTO {
    private String email;
    @JsonProperty("is_comment_accepted")
    private boolean isCommentAccepted;
    List<ErrorDto> errors;
}
