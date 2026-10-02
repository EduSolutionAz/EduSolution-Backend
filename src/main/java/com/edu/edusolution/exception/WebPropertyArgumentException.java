package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.WEB_PROPERTY_ILLEGAL_ARGUMENT_CODE;

public class WebPropertyArgumentException extends BaseApplicationException {
    public WebPropertyArgumentException(String message) {
        super(WEB_PROPERTY_ILLEGAL_ARGUMENT_CODE,message);
    }
}
