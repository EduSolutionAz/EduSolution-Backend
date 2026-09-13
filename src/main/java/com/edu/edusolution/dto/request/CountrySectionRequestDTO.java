package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountrySectionRequestDTO {
    @JsonProperty("country_name")
    private String countryName;
}
