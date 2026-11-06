package com.edu.edusolution.dto.response.country;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.COUNTRY_NAME_JSON;
import static com.edu.edusolution.constants.DtoConstants.IS_COUNTRY_CREATED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateCountryResponseDTO {

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty(IS_COUNTRY_CREATED_JSON)
    private Boolean isCountryAdded;
}
