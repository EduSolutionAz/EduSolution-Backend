package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversitySectionRequestDTO {

    @JsonProperty("university_name")
    @NotNull(message = UNIVERSITY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_IS_REQUIRED_BLANK_MSG)
    private String universityName;
}
