package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddNewFacultyRequestDTO {

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
