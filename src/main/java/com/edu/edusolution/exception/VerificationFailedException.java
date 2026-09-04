package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.VERIFICATION_FAILED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.VERIFICATION_FAILED_MSG;

public class VerificationFailedException extends BaseApplicationException {

    public VerificationFailedException() {
        super(VERIFICATION_FAILED_CODE, VERIFICATION_FAILED_MSG);
    }
}
