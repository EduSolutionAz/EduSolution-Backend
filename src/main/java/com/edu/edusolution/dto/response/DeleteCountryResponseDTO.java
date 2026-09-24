package com.edu.edusolution.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteCountryResponseDTO {
    private String countryName;
    private boolean isDeleted;
}
