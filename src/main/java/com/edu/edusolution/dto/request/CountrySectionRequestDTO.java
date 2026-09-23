package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.COUNTRY_IS_REQUIRED_BLANK_MSG;
import static com.edu.edusolution.constants.DtoConstants.COUNTRY_IS_REQUIRED_NULL_MSG;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountrySectionRequestDTO {
    @JsonProperty("country_name")
    @NotNull(message = COUNTRY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IS_REQUIRED_BLANK_MSG)
    private String countryName;
}
