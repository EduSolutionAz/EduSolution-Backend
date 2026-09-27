package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Getter
public class FacultyAlreadyExistsException extends BaseApplicationException {
    public FacultyAlreadyExistsException() {
        super(FACULTY_ALREADY_EXISTS_CODE, FACULTY_ALREADY_EXISTS_MSG);
    }
}
