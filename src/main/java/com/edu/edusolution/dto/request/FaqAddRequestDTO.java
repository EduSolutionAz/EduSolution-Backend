package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.FAQ_QUESTION_JSON;
import static com.edu.edusolution.constants.DtoConstants.FAQ_TEXT_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FaqAddRequestDTO {
    @JsonProperty(FAQ_QUESTION_JSON)
    private String faqQuestion;
    @JsonProperty(FAQ_TEXT_JSON)
    private String faqText;
}
