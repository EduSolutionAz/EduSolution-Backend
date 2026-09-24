package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class EmailException extends BaseApplicationException {
    public EmailException() {
        super(MAIL_PROBLEM_CODE,MAIL_PROBLEM_MSG);
    }
}
