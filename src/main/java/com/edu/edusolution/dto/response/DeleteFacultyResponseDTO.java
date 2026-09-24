package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DeleteFacultyResponseDTO {
    @JsonProperty(FACULTY_JSON)
    private String facultyName;
    @JsonProperty(UNIVERSITY_JSON)
    private String universityName;
    @JsonProperty(IS_DELETED_JSON)
    private boolean isDeleted;
}
