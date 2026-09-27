package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryAddResponseDTO {

    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("is_country_created")
    private Boolean isCountryAdded;
}
