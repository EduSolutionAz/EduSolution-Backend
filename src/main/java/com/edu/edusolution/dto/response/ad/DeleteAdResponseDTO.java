package com.edu.edusolution.dto.response.ad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteAdResponseDTO {
    @JsonProperty("title")
    private String title;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;
}
