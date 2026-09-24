package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.FACULTY_JSON;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UniversityFacultiesResponseDTO {
    @JsonProperty(FACULTY_JSON)
    private String facultyName;
}
