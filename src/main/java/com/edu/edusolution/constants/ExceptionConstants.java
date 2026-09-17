package com.edu.edusolution.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionConstants {

    // Client Already Exists
    public static String CLIENT_ALREADY_EXISTS_CODE = "CLIENT_ALREADY_EXISTS";
    public static String CLIENT_ALREADY_EXISTS_EMAIL_MSG = "Client with this email is already exists. Try to login or use another email";
    public static String CLIENT_ALREADY_EXISTS_EMAIL_PHONE_MSG = "Client with this email or phone is already exists. Try to login or use another email or phone";

    // Mail Sending
    public static String EMAIL_SENDING_FAILED_CODE = "EMAIL_SENDING_FAILED";
    public static String EMAIL_SENDING_FAILED_MSG = "Email sending is failed. Please try again";

    // Client Not Found
    public static String CLIENT_NOT_FOUND_CODE = "CLIENT_NOT_FOUND";
    public static String CLIENT_NOT_FOUND_NV_MSG = "Client with this email not found. Client is already verified or not registered";
    public static String CLIENT_NOT_FOUND_MSG = "Client is not found";

    // Verification Failed
    public static String VERIFICATION_FAILED_CODE = "VERIFICATION_FAILED";
    public static String VERIFICATION_FAILED_MSG = "Verification is failed. Please try again";
    public static String VERIFICATION_CODE_FAILED_MSG = "Verification is failed. Enter correct code, or click send again";

    // Already Verified
    public static String CLIENT_ALREADY_VERIFIED_CODE = "CLIENT_ALREADY_VERIFIED";
    public static String CLIENT_ALREADY_VERIFIED_MSG = "Client is already verified, password creation is required";

    // Already Verified
    public static String CLIENT_NOT_VERIFIED_CODE = "CLIENT_NOT_VERIFIED";
    public static String CLIENT_NOT_VERIFIED_MSG = "Client is not verified, verification is required";

    //Data Integrity
    public static final String DATA_INTEGRITY_PROBLEM_CODE = "DATA_INTEGRITY_PROBLEM";

    // Country Exception
    public static final String COUNTRY_NOT_FOUND_CODE = "COUNTRY_NOT_FOUND";
    public static final String COUNTRY_NOT_FOUND_MSG = "Country with this name not found";
}
