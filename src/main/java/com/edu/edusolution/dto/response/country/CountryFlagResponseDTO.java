package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.COUNTRY_FLAG_URL_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryFlagResponseDTO {
    @JsonProperty(COUNTRY_FLAG_URL_JSON)
    private String countryFlagUrl;
}
