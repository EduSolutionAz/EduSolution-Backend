package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.COUNTRY_NOT_FOUND_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.COUNTRY_NOT_FOUND_MSG;

public class CountryNotFoundException extends BaseApplicationException {
    public CountryNotFoundException() {
        super(COUNTRY_NOT_FOUND_CODE, COUNTRY_NOT_FOUND_MSG);
    }
}
