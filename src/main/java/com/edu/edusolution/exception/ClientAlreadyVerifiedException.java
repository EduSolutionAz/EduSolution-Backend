package com.edu.edusolution.exception;


import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_ALREADY_VERIFIED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_ALREADY_VERIFIED_MSG;

public class ClientAlreadyVerifiedException extends BaseApplicationException {

    public ClientAlreadyVerifiedException() {
        super(CLIENT_ALREADY_VERIFIED_CODE, CLIENT_ALREADY_VERIFIED_MSG);
    }
}
