package com.edu.edusolution.dto.response.university;

import com.edu.edusolution.entity.university.UniversityType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UniversitySectionResponseDTO {

    @JsonProperty(UNIVERSITY_NAME_JSON)
    private String universityName;

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;

    @JsonProperty(UNIVERSITY_TYPE_JSON)
    private UniversityType universityType;

    @JsonProperty(FEE_JSON)
    private BigDecimal fee;

    @JsonProperty(SEMESTER_COUNT_JSON)
    private Integer semesterCount;

    @JsonProperty(UNIVERSITY_LOGO_JSON)
    private String universityLogo;

    @JsonProperty(CITY_JSON)
    private String city;

    @JsonProperty(CONTENT_JSON)
    private String content;

    @JsonProperty(AREA_JSON)
    private String area;

    @JsonProperty(IS_PARTNER_JSON)
    private Boolean isPartner;

    @JsonProperty("faculties")
    private List<String> faculties;
}
