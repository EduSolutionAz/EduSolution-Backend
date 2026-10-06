package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class AdNotFoundException extends BaseApplicationException {
    // todo - change constants
    public AdNotFoundException() {
        super(AD_NOT_FOUND_CODE, AD_NOT_FOUND_MSG);
    }
}
