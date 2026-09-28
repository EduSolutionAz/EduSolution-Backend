package com.edu.edusolution.dto.response.university;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UniversitiesResponseDTO {
    @JsonProperty("university_name")
    private String universityName;
    @JsonProperty("country_name")
    private String countryName;
}
