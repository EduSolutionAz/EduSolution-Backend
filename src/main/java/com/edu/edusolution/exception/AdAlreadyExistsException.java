package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class AdAlreadyExistsException extends BaseApplicationException{
    public AdAlreadyExistsException() {
        super(AD_ALREADY_EXISTS_CODE, AD_ALREADY_EXISTS_MSG);
    }
}
