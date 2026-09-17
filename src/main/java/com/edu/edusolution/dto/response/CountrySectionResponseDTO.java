package com.edu.edusolution.dto.response;

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
    private String title;
    private String photoUrl;
    private String content;
    private List<String> universities;
    private String areas;
}
