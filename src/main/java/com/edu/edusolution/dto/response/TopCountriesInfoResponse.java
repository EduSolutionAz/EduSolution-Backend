package com.edu.edusolution.dto.response;

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
    private int universityCount;
    @JsonProperty("visa_help")
    private boolean visaHelp;
    @JsonProperty("dormitory_help")
    private boolean dormitoryHelp;
    @JsonProperty("country_bg_url")
    private String countryBGUrl;
}
