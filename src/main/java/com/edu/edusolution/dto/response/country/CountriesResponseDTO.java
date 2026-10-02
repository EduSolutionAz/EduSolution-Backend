package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountriesResponseDTO {

    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("university_count")
    private Integer universityCount;
    @JsonProperty("is_visa_help")
    private Boolean visaHelp;
    @JsonProperty("is_dormitory_help")
    private Boolean dormitoryHelp;
}
