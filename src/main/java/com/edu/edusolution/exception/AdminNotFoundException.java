package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.ADMIN_NOT_FOUND_CODE;

public class AdminNotFoundException extends BaseApplicationException {
    public AdminNotFoundException(String message) {
        super(ADMIN_NOT_FOUND_CODE,message);
    }
}
