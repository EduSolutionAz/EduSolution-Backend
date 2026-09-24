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
    public static final String DATA_INSERT_ERROR_CODE = "DATA_INSERT_ERROR";
    public static final String DATA_INSERT_COUNTRY_MSG = "An error occurred while saving the country";
    public static final String DATA_INSERT_COUNTRY_SECTION_MSG = "An error occurred while saving the country's section part";
    public static final String DATA_DELETE_ERROR_CODE = "DATA_DELETE_ERROR";
    public static final String DATA_DELETE_S3_COUNTRY_MSG = "An error occurred while deleting country from storage";
    public static final String DATA_DELETE_S3_UNIVERSITY_MSG = "An error occurred while deleting university from storage";

    // Country Exception
    public static final String COUNTRY_NOT_FOUND_CODE = "COUNTRY_NOT_FOUND";
    public static final String COUNTRY_NOT_FOUND_MSG = "Country with this name not found";
    public static final String COUNTRY_ALREADY_EXISTS_CODE = "COUNTRY_ALREADY_EXISTS";
    public static final String COUNTRY_ALREADY_EXISTS_MSG = "Country with this name already exists";
    public static final String COUNTRY_UPLOAD_ERROR_CODE = "COUNTRY_UPLOAD_ERROR";
    public static final String COUNTRY_UPLOAD_ERROR_MSG = "An error occurred while uploading the country";

    // University Exception
    public static final String UNIVERSITY_NOT_FOUND_CODE = "UNIVERSITY_NOT_FOUND";
    public static final String UNIVERSITY_NOT_FOUND_MSG = "University with this name not found";
    public static final String UNIVERSITY_ALREADY_EXISTS_CODE = "UNIVERSITY_ALREADY_EXISTS";
    public static final String UNIVERSITY_ALREADY_EXISTS_MSG = "University with this name already exists";

    // Email Exception
    public static final String MAIL_PROBLEM_CODE = "MAIL_PROBLEM";
    public static final String MAIL_PROBLEM_MSG = "An error occurred while sending email";

    // Faculty
    public static final String FACULTY_NOT_FOUND_CODE = "FACULTY_NOT_FOUND";
    public static final String FACULTY_NOT_FOUND_MSG = "Faculty with this name not found";
    public static final String FACULTY_ALREADY_EXISTS_CODE = "FACULTY_ALREADY_EXISTS";
    public static final String FACULTY_ALREADY_EXISTS_MSG = "Faculty with this name already exists";
}
