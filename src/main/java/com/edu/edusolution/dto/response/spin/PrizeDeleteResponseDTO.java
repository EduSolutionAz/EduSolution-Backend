package com.edu.edusolution.dto.response.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.IS_DELETED_JSON;
import static com.edu.edusolution.constants.DtoConstants.PRIZE_NAME_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrizeDeleteResponseDTO {
    @JsonProperty(PRIZE_NAME_JSON)
    private String prizeName;
    @JsonProperty(IS_DELETED_JSON)
    private Boolean isDeleted;
}
