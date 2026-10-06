package com.edu.edusolution.dto.response.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.PRIZE_NAME_JSON;
import static com.edu.edusolution.constants.DtoConstants.PRIZE_WEIGHT_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrizesResponseDTO {

    @JsonProperty(PRIZE_NAME_JSON)
    private String prizeName;
    @JsonProperty(PRIZE_WEIGHT_JSON)
    private Integer prizeWeight;
}
