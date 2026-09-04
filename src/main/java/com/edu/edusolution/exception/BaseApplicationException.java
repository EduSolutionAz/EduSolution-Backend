package com.edu.edusolution.exception;

import lombok.Getter;

@Getter
public class BaseApplicationException extends RuntimeException {
    String code;
    public BaseApplicationException(String code, String message) {
        super(message);
        this.code = code;
    }
}
