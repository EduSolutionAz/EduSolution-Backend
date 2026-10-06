package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.RESULT_NOT_FOUND_CODE;

public class ResultNotFoundException extends BaseApplicationException {
    public ResultNotFoundException(String message) {
        super(RESULT_NOT_FOUND_CODE, message);
    }
}
