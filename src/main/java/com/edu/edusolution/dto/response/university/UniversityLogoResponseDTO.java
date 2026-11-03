package com.edu.edusolution.dto.response.university;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_LOGO_URL_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UniversityLogoResponseDTO {
    @JsonProperty(UNIVERSITY_LOGO_URL_JSON)
    private String universityLogoUrl;
}
