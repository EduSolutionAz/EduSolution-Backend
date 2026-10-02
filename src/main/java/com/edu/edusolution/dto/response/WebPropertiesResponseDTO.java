package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebPropertiesResponseDTO {

    @JsonProperty(STUDENTS_HELPED_JSON)
    private Integer studentHelped;

    @JsonProperty(VISA_SUCCESS_RATE_JSON)
    private BigDecimal visaSuccessRate;

    @JsonProperty(ADMISSIONS_SENT_JSON)
    private Integer admissionSent;

    @JsonProperty(SUCCESSFUL_ADMISSION_JSON)
    private Integer successfulAdmission;

    @JsonProperty(VISA_HELP_JSON)
    private Integer visaHelp;

    @JsonProperty(SUCCESSFUL_VISA_HELP_JSON)
    private Integer successfulVisaHelp;


}
