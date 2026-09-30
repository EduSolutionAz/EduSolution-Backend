package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.COUNTRY_DELETE_ERROR_CODE;

public class CountryDeleteException extends BaseApplicationException {
    public CountryDeleteException(String message) {
        super(COUNTRY_DELETE_ERROR_CODE,message);
    }
}
