package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountriesResponseDTO {

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty(UNIVERSITY_COUNT_JSON)
    private Integer universityCount;
    @JsonProperty(IS_VISA_HELP_JSON)
    private Boolean visaHelp;
    @JsonProperty(IS_DORM_HELP_JSON)
    private Boolean dormitoryHelp;
}
