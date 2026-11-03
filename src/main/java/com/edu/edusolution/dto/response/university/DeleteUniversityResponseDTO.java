package com.edu.edusolution.dto.response.university;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.IS_DELETED_JSON;
import static com.edu.edusolution.constants.DtoConstants.UNIVERSITY_NAME_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteUniversityResponseDTO {

    @JsonProperty(UNIVERSITY_NAME_JSON)
    private String universityName;
    @JsonProperty(IS_DELETED_JSON)
    private Boolean isDeleted;
}
