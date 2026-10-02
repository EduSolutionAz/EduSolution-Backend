package com.edu.edusolution.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddWebPropertiesRequestDTO {

    @JsonProperty(STUDENTS_HELPED_JSON)
    @NotNull(message = STUDENTS_HELP_NULL_MSG)
    private Integer studentsHelped;

    @JsonProperty(ADMISSIONS_SENT_JSON)
    @NotNull(message = ADMISSION_SENT_NULL_MSG)
    private Integer admissionsSent;

    @JsonProperty(SUCCESSFUL_ADMISSION_JSON)
    @NotNull(message = SUCCESSFUL_ADMISSION_NULL_MSG)
    private Integer successfulAdmissions;

    @JsonProperty(VISA_HELP_JSON)
    @NotNull(message = VISA_HELP_NULL_MSG)
    private Integer visaHelp;

    @JsonProperty(SUCCESSFUL_VISA_HELP_JSON)
    @NotNull(message = SUCCESSFUL_VISA_HELP_NULL_MSG)
    private Integer successfulVisaHelp;


}
