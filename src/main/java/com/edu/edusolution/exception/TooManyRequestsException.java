package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.TOO_MANY_REQUEST_CODE;

public class TooManyRequestsException extends BaseApplicationException {
    public TooManyRequestsException(String message) {
        super(TOO_MANY_REQUEST_CODE, message);
    }
}
