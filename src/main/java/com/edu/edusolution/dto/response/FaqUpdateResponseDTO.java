package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.FAQ_ID_JSON;
import static com.edu.edusolution.constants.DtoConstants.IS_UPDATED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaqUpdateResponseDTO {
    @JsonProperty(FAQ_ID_JSON)
    private UUID faqId;
    @JsonProperty(IS_UPDATED_JSON)
    private Boolean isUpdated;
}
