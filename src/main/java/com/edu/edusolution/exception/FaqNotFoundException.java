package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.FAQ_NOT_FOUND_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.FAQ_NOT_FOUND_MSG;

public class FaqNotFoundException extends BaseApplicationException {
    public FaqNotFoundException() {
        super(FAQ_NOT_FOUND_CODE, FAQ_NOT_FOUND_MSG);
    }
}
