package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.APPLICANT_NOT_FOUND_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.APPLICANT_NOT_FOUND_MSG;

public class ApplicantNotFoundException extends BaseApplicationException {
    public ApplicantNotFoundException() {
        super(APPLICANT_NOT_FOUND_CODE, APPLICANT_NOT_FOUND_MSG);
    }
}
