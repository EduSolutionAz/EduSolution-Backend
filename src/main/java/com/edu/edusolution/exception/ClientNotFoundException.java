package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_NOT_FOUND_CODE;

public class ClientNotFoundException extends BaseApplicationException {
    public ClientNotFoundException(String message) {
        super(CLIENT_NOT_FOUND_CODE, message);
    }
}
