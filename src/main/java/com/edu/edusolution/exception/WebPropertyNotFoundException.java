package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.WEB_PROPERTY_NOT_FOUND_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.WEB_PROPERTY_NOT_FOUND_MSG;

public class WebPropertyNotFoundException extends BaseApplicationException {
    public WebPropertyNotFoundException() {
        super(WEB_PROPERTY_NOT_FOUND_CODE,WEB_PROPERTY_NOT_FOUND_MSG);
    }
}
