package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantCommentAddingResponseDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty(namespace = "is_added")
    private boolean isAdded;
}
