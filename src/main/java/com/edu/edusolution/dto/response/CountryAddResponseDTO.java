package com.edu.edusolution.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryAddResponseDTO {

    private String countryName;
    private boolean isCountryAdded;
}
