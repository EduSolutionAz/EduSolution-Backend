package com.edu.edusolution.exception;

public class TokenNotFoundException extends BaseApplicationException {
    public TokenNotFoundException() {
        super("TOKEN_NOT_FOUND", "Token is not found in database");
    }
}
