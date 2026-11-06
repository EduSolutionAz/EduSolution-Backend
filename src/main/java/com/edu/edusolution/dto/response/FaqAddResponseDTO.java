package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.FAQ_ID_JSON;
import static com.edu.edusolution.constants.DtoConstants.IS_CREATED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaqAddResponseDTO {
    @JsonProperty(FAQ_ID_JSON)
    private UUID faqId;
    @JsonProperty(IS_CREATED_JSON)
    private Boolean isCreated;
}
