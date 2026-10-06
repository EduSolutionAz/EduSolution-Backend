package com.edu.edusolution.dto.response.spin;

import com.edu.edusolution.dto.ErrorDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrizeAddResponseDTO {

    @JsonProperty(PRIZE_NAME_JSON)
    private String prizeName;
    @JsonProperty(IS_CREATED_JSON)
    private Boolean isAdded;
    @JsonProperty("errors")
    private List<ErrorDto> errors;
}
