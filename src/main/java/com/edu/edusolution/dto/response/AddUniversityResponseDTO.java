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
public class AddUniversityResponseDTO {
    @JsonProperty("university_name")
    private String universityName;
    @JsonProperty("is_created")
    private boolean isCreated;
}
