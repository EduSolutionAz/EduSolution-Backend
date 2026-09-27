package com.edu.edusolution.dto.response.university;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UniversitySectionResponseDTO {

    private String title;
    @JsonProperty("photo_url")
    private String photoUrl;
    @JsonProperty("view_url")
    private String viewUrl;
    private String content;
    private List<String> faculties;
}
