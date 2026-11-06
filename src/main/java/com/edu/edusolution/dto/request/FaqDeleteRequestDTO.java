package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.FAQ_ID_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FaqDeleteRequestDTO {
    @JsonProperty(FAQ_ID_JSON)
    private UUID faqId;
}
