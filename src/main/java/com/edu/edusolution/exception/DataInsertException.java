package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.DATA_INSERT_ERROR_CODE;

public class DataInsertException extends BaseApplicationException {
    public DataInsertException(String message) {
        super(DATA_INSERT_ERROR_CODE,message);
    }
}
