package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class CountryUploadException extends BaseApplicationException {
    public CountryUploadException() {
        super(COUNTRY_UPLOAD_ERROR_CODE, COUNTRY_UPLOAD_ERROR_MSG);
    }
}
