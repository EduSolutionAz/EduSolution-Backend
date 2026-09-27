package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Getter
public class UniversityAlreadyExistsException extends BaseApplicationException {

    public UniversityAlreadyExistsException() {
        super(UNIVERSITY_ALREADY_EXISTS_CODE, UNIVERSITY_ALREADY_EXISTS_MSG);
    }
}
