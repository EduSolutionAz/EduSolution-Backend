package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.SPIN_PLAY_ERROR;

public class SpinGamePlayException extends BaseApplicationException {
    public SpinGamePlayException(String message) {
        super(SPIN_PLAY_ERROR, message);
    }
}
