package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class FacultyNotFoundException extends BaseApplicationException {
    //Todo change the constants
    public FacultyNotFoundException() {
        super(FACULTY_NOT_FOUND_CODE, FACULTY_NOT_FOUND_MSG);
    }
}
