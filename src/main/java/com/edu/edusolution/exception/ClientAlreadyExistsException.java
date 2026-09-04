package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_ALREADY_EXISTS_CODE;

@Getter
public class ClientAlreadyExistsException extends BaseApplicationException {

    public ClientAlreadyExistsException(String message) {
        super(CLIENT_ALREADY_EXISTS_CODE, message);
    }
}
