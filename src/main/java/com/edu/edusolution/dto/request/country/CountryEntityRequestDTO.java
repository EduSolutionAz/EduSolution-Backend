package com.edu.edusolution.dto.request.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryEntityRequestDTO {
    @JsonProperty("country_name")
    private String countryName;
}
