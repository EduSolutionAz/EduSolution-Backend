package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TopCountriesInfoResponse {
    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty(UNIVERSITY_COUNT_JSON)
    private Integer universityCount;
    @JsonProperty(VISA_HELP_JSON)
    private Boolean visaHelp;
    @JsonProperty(DORM_HELP_JSON)
    private Boolean dormitoryHelp;
    @JsonProperty(COUNTRY_BG_URL_JSON)
    private String countryBGUrl;
}
