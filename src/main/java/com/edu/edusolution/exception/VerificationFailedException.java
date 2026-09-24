package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.VERIFICATION_FAILED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.VERIFICATION_FAILED_MSG;

@Getter
public class VerificationFailedException extends BaseApplicationException {

    private String message;

    public VerificationFailedException() {
        super(VERIFICATION_FAILED_CODE, VERIFICATION_FAILED_MSG);
    }
    public VerificationFailedException(String message){
        super(VERIFICATION_FAILED_CODE, message);
    }
}
