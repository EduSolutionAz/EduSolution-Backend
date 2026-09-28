package com.edu.edusolution.dto.response.university;

import com.edu.edusolution.entity.university.UniversityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UniversityEntityResponseDTO {

    @NotNull(message = UNIVERSITY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_IS_REQUIRED_BLANK_MSG)
    @Size(max = 75, message = UNIVERSITY_SIZE_MSG)
    private String universityName;

    @NotNull(message = COUNTRY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IS_REQUIRED_BLANK_MSG)
    @Size(max = 50, message = COUNTRY_LENGTH_MSG)
    private String countryName;

    @NotNull(message = UNIVERSITY_TYPE_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_TYPE_IS_REQUIRED_BLANK_MSG)
    private UniversityType universityType;

    @NotNull(message = DESCRIPTION_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = DESCRIPTION_IS_REQUIRED_BLANK_MSG)
    private String shortDescription;

    @NotNull(message = FEE_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = FEE_IS_REQUIRED_BLANK_MSG)
    private BigDecimal fee;

    @NotNull(message = UNIVERSITY_LOGO_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_LOGO_IS_REQUIRED_BLANK_MSG)
    private String universityLogo;

    @NotNull(message = CITY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = CITY_IS_REQUIRED_BLANK_MSG)
    private String city;

    @NotNull(message = CONTENT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = CONTENT_IS_REQUIRED_BLANK_MSG)
    private String content;

    @NotNull(message = AREA_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = AREA_IS_REQUIRED_BLANK_MSG)
    private String area;

    @NotNull(message = PARTNER_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = PARTNER_IS_REQUIRED_BLANK_MSG)
    private Boolean isPartner;
}
