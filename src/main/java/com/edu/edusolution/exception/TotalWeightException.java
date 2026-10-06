package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.TOTAL_WEIGHT_CODE;

public class TotalWeightException extends BaseApplicationException {
    public TotalWeightException(String message) {
        super(TOTAL_WEIGHT_CODE, message);
    }
}
