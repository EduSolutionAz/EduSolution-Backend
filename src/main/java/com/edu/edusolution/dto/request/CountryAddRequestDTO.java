package com.edu.edusolution.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

import static com.edu.edusolution.constants.DtoConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryAddRequestDTO {
    @NotNull(message = COUNTRY_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IS_REQUIRED_BLANK_MSG)
    @Size(max = 50, message = COUNTRY_LENGTH_MSG)
    private String countryName;

    @NotNull(message = FLAG_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = FLAG_IS_REQUIRED_BLANK_MSG)
    private MultipartFile flagImage;

    @NotNull(message = COUNTRY_IMAGE_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = COUNTRY_IMAGE_IS_REQUIRED_BLANK_MSG)
    private MultipartFile countryImage;

    @NotNull(message = UNIVERSITY_COUNT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = UNIVERSITY_COUNT_IS_REQUIRED_BLANK_MSG)
    private int universityCount;

    @NotNull(message = TUITION_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = TUITION_IS_REQUIRED_BLANK_MSG)
    private BigDecimal tuitionFee;

    @NotNull(message = RENTAL_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = RENTAL_IS_REQUIRED_BLANK_MSG)
    private BigDecimal rentalFee;

    @NotNull(message = VISA_HELP_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = VISA_HELP_IS_REQUIRED_BLANK_MSG)
    private boolean isVisaHelp;

    @NotNull(message = DORMITORY_HELP_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = DORMITORY_HELP_IS_REQUIRED_BLANK_MSG)
    private boolean isDormitoryHelp;

    @NotNull(message = CONTENT_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = CONTENT_IS_REQUIRED_BLANK_MSG)
    private String content;

    @NotNull(message = AREA_IS_REQUIRED_NULL_MSG)
    @NotBlank(message = AREA_IS_REQUIRED_BLANK_MSG)
    private String area;

}
