package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Getter
public class PrizeAlreadyExistsException extends BaseApplicationException {

    public PrizeAlreadyExistsException() {
        super(PRIZE_ALREADY_EXISTS_CODE, PRIZE_ALREADY_EXISTS_MSG);
    }
}
