package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class UniversityNotFoundException extends BaseApplicationException {
    public UniversityNotFoundException() {
        super(UNIVERSITY_NOT_FOUND_CODE, UNIVERSITY_NOT_FOUND_MSG);
    }
}
