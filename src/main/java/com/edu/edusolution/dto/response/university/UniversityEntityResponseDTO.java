package com.edu.edusolution.dto.response.university;

import com.edu.edusolution.entity.university.UniversityType;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(UNIVERSITY_NAME_JSON)
    private String universityName;

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;

    @JsonProperty(UNIVERSITY_TYPE_JSON)
    private UniversityType universityType;

    @JsonProperty(FEE_JSON)
    private BigDecimal fee;

    @JsonProperty(UNIVERSITY_LOGO_JSON)
    private String universityLogo;

    @JsonProperty(CITY_JSON)
    private String city;

    @JsonProperty(CONTENT_JSON)
    private String content;

    @JsonProperty(SHORT_DESC_JSON)
    private String shortDescription;

    @JsonProperty(SEMESTER_COUNT_JSON)
    private Integer semesterCount;

    @JsonProperty(AREA_JSON)
    private String area;

    @JsonProperty(IS_PARTNER_JSON)
    private Boolean isPartner;
}
