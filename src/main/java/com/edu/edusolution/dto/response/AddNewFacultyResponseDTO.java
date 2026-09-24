package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewFacultyResponseDTO {

    @JsonProperty(UNIVERSITY_JSON)
    private String facultyName;
    @JsonProperty(FACULTY_JSON)
    private String universityName;
    @JsonProperty(IS_CREATED_JSON)
    private boolean isCreated;
}
