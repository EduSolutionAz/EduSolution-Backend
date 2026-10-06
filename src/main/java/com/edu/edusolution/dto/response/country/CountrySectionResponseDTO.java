package com.edu.edusolution.dto.response.country;

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
public class CountrySectionResponseDTO {
    @JsonProperty("title")
    private String title;
    @JsonProperty("photo_url")
    private String photoUrl;
    @JsonProperty("content")
    private String content;
    @JsonProperty("universities")
    private List<String> universities;
    @JsonProperty("areas")
    private String areas;
}
