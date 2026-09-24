package com.edu.edusolution.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteUniversityResponseDTO {
    private String universityName;
    private boolean isDeleted;
}
