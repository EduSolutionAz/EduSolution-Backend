package com.edu.edusolution.dto.response;

import com.edu.edusolution.entity.applicant.ApplicantServices;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantCommentResponseDTO {
    @JsonProperty("applicant_name")
    private String applicantName;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("service")
    private ApplicantServices service;
}
