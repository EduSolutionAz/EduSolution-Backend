package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaqResponseDTO {
    @JsonProperty(FAQ_ID_JSON)
    private UUID faqId;
    @JsonProperty(FAQ_QUESTION_JSON)
    private String faqQuestion;
    @JsonProperty(FAQ_ANSWER_JSON)
    private String faqAnswer;
}
