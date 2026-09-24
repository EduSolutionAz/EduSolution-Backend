package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;
import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_IS_REQUIRED_BLANK_MSG;
import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_IS_REQUIRED_NULL_MSG;
import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_JSON;
import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_SIZE_MSG;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteFacultyRequestDTO {

    @JsonProperty(FACULTY_JSON)
    @NotNull(message = FACULTY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = FACULTY_IS_REQUIRED_BLANK_MSG)
    private String facultyName;

    @JsonProperty(UNIVERSITY_JSON)
    @NotNull(message = UNIVERSITY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_IS_REQUIRED_BLANK_MSG)
    @Size(message = UNIVERSITY_SIZE_MSG, max = 75)
    private String universityName;
}
