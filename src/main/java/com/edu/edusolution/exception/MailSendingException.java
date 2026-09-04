package com.edu.edusolution.exception;

import lombok.Getter;

import static com.edu.edusolution.constants.ExceptionConstants.EMAIL_SENDING_FAILED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.EMAIL_SENDING_FAILED_MSG;

@Getter
public class MailSendingException extends BaseApplicationException {

    private final boolean isSent;
    public MailSendingException() {
        super(EMAIL_SENDING_FAILED_CODE, EMAIL_SENDING_FAILED_MSG);
        this.isSent = false;
    }
}
