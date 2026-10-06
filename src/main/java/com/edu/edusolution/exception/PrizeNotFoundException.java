package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Getter
public class PrizeNotFoundException extends BaseApplicationException {

    public PrizeNotFoundException() {
        super(PRIZE_NOT_FOUND_CODE, PRIZE_NOT_FOUND_MSG);
    }
}
