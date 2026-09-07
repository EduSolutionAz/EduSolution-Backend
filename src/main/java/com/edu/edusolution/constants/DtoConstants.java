package com.edu.edusolution.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoConstants {
    
    public static final String EMAIL_IS_REQUIRED_MSG = "Email is required to proceed";
    public static final String EMAIL_LENGTH_MSG = "Email must not exceed 50 characters";
    public static final String EMAIL_VALID_MSG = "Email must be a valid email address";
    public static final String EMAIL_JSON_FIELD = "email";

    public static final String PASSWORD_IS_REQUIRED_MSG = "Password is required to proceed";
    public static final String PASSWORD_LENGTH_MSG = "Password must not exceed 20 characters and less than 9 characters";
    public static final String PASSWORD_JSON_FIELD = "password";

    public static final String NAME_IS_REQUIRED_MSG = "Name is required to proceed";
    public static final String NAME_LENGTH_MSG = "Name must not exceed 50 characters";
    public static final String NAME_JSON_FIELD = "name";

    public static final String PHONE_IS_REQUIRED_MSG = "Phone is required to proceed";
    public static final String PHONE_LENGTH_MSG = "Phone must not exceed 15 characters or less than 12 characters";
    public static final String PHONE_JSON_FIELD = "phone";

    public static final String CODE_IS_REQUIRED_MSG = "CODE is required to proceed";
    public static final String CODE_LENGTH_MSG = "CODE must be 6 characters";
    public static final String CODE_JSON_FIELD = "CODE";
}
