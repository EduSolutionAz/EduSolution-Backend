package com.edu.edusolution.dto.request.university;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversityByCountryRequestDTO {
    @NotNull(message = COUNTRY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IS_REQUIRED_BLANK_MSG)
    @Size(max = 50, message = COUNTRY_LENGTH_MSG)
    private String countryName;
}
