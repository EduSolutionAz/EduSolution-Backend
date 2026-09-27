package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.COUNTRY_ALREADY_EXISTS_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.COUNTRY_ALREADY_EXISTS_MSG;

public class CountryAlreadyExists extends BaseApplicationException {
    public CountryAlreadyExists() {
        super(COUNTRY_ALREADY_EXISTS_CODE, COUNTRY_ALREADY_EXISTS_MSG);
    }
}
