package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteCountryRequestDTO {
    @JsonProperty("country_name")
    @NotNull(message = COUNTRY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IS_REQUIRED_BLANK_MSG)
    @Size(max = 50, message = COUNTRY_LENGTH_MSG)
    private String countryName;
}
