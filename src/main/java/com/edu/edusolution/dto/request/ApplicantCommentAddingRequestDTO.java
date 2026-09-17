package com.edu.edusolution.dto.request;

import com.edu.edusolution.entity.applicant.ApplicantServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApplicantCommentAddingRequestDTO {
    private String name;
    private String comment;
    private ApplicantServices service;
}
