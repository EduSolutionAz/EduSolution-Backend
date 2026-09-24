package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.DATA_DELETE_ERROR_CODE;

public class DataDeleteException extends BaseApplicationException {
    public DataDeleteException(String message) {
        super(DATA_DELETE_ERROR_CODE,message);
    }
}
