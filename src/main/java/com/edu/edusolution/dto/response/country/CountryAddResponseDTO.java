package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.COUNTRY_NAME_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryAddResponseDTO {

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty("is_country_created")
    private Boolean isCountryAdded;
}
