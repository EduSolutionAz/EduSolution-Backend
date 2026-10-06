package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.PARTICIPANT_NOT_FOUND_CODE;

public class ParticipantNotFoundException extends BaseApplicationException {
    public ParticipantNotFoundException(String message) {
        super(PARTICIPANT_NOT_FOUND_CODE, message);
    }
}
