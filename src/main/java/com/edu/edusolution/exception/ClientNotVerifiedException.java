package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_NOT_VERIFIED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.CLIENT_NOT_VERIFIED_MSG;

public class ClientNotVerifiedException extends BaseApplicationException {

    public ClientNotVerifiedException() {
        super(CLIENT_NOT_VERIFIED_CODE, CLIENT_NOT_VERIFIED_MSG);
    }
}
