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
public class DeleteCountryResponseDTO {
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("is_deleted")
    private boolean isDeleted;
}
