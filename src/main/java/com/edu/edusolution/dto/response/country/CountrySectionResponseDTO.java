package com.edu.edusolution.dto.response.country;

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
public class CountrySectionResponseDTO {
    @JsonProperty(TITLE_JSON)
    private String title;
    @JsonProperty(PHOTO_URL_JSON)
    private String photoUrl;
    @JsonProperty(CONTENT_JSON)
    private String content;
    @JsonProperty(UNIVERSITIES_JSON)
    private List<String> universities;
    @JsonProperty(UNIVERSITY_COST_JSON)
    private int universityCost;
    @JsonProperty(MONTHLY_SPENDING_JSON)
    private BigDecimal monthlySpending;
    @JsonProperty(RENTAL_FEE_JSON)
    private int rentalFee;
    @JsonProperty(AREAS_JSON)
    private String areas;
}
