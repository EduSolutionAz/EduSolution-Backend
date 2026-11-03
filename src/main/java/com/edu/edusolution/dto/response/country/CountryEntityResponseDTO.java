package com.edu.edusolution.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class CountryEntityResponseDTO {

    @JsonProperty(COUNTRY_NAME_JSON)
    private String countryName;
    @JsonProperty(FLAG_IMG_JSON)
    private String flagImage;
    @JsonProperty(COUNTRY_IMG_JSON)
    private String countryImage;
    @JsonProperty(UNIVERSITY_COUNT_JSON)
    private Integer universityCount;
    @JsonProperty(TUITION_FEE_JSON)
    private BigDecimal tuitionFee;
    @JsonProperty(RENTAL_FEE_JSON)
    private BigDecimal rentalFee;
    @JsonProperty(MONTHLY_SPENDING_JSON)
    private BigDecimal monthlySpending;
    @JsonProperty(IS_VISA_HELP_JSON)
    private Boolean isVisaHelp;
    @JsonProperty(IS_DORM_HELP_JSON)
    private Boolean isDormitoryHelp;
    @JsonProperty(IS_TOP_LIST_JSON)
    private Boolean isTopList;
    @JsonProperty(CONTENT_JSON)
    private String content;
    @JsonProperty(AREA_JSON)
    private String area;
    @JsonProperty(ICON_JSON)
    private String icon;
}
