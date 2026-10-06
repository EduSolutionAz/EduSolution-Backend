package com.edu.edusolution.dto.request.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrizeAddRequestDTO {
    @JsonProperty(PRIZE_NAME_JSON)
    @Size(max = PRIZE_NAME_LENGTH, message = PRIZE_NAME_LENGTH_MSG)
    @NotBlank(message = PRIZE_NAME_BLANK)
    @NotNull(message = PRIZE_NAME_NOT_NULL)
    private String prizeName;

    @JsonProperty(PRIZE_WEIGHT_JSON)
    @Min(PRIZE_WEIGHT_MIN)
    @Max(PRIZE_WEIGHT_MAX)
    private Integer prizeWeight;
}
