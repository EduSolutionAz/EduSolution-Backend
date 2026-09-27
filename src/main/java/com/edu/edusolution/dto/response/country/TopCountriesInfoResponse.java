package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TopCountriesInfoResponse {
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("university_count")
    private Integer universityCount;
    @JsonProperty("visa_help")
    private Boolean visaHelp;
    @JsonProperty("dormitory_help")
    private Boolean dormitoryHelp;
    @JsonProperty("country_bg_url")
    private String countryBGUrl;
}
