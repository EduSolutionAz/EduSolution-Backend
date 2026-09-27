package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.ADMIN_CREATION_ERROR_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.ADMIN_CREATION_ERROR_MSG;

public class AdminCreationException extends BaseApplicationException {
    public AdminCreationException() {
        super(ADMIN_CREATION_ERROR_CODE, ADMIN_CREATION_ERROR_MSG);
    }
}
