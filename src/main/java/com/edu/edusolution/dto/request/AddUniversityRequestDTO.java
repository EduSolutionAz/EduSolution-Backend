package com.edu.edusolution.dto.request;

import com.edu.edusolution.entity.university.UniversityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUniversityRequestDTO {

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

    @NotNull(message = UNIVERSITY_LOGO_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_LOGO_IS_REQUIRED_BLANK_MSG)
    private MultipartFile universityLogo;

    @NotNull(message = CITY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = CITY_IS_REQUIRED_BLANK_MSG)
    private String city;

    @NotNull(message = CONTENT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = CONTENT_IS_REQUIRED_BLANK_MSG)
    private String content;

    @NotNull(message = AREA_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = AREA_IS_REQUIRED_BLANK_MSG)
    private String area;
}
