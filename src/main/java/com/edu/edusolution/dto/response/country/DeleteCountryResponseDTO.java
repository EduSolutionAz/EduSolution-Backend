package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.COUNTRY_NAME_JSON;
import static com.edu.edusolution.constants.DtoConstants.IS_DELETED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteCountryResponseDTO {
    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty(IS_DELETED_JSON)
    private Boolean isDeleted;
}
