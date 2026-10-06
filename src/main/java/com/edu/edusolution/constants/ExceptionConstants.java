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
    public static final String DATA_DELETE_S3_AD_MSG = "An error occurred while deleting ad from storage";

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

    public static final String ADMIN_NOT_FOUND_CODE = "ADMIN_NOT_FOUND";
    public static final String ADMIN_CREATION_ERROR_CODE = "ADMIN_CREATION_ERROR";
    public static final String ADMIN_CREATION_ERROR_MSG = "An error occurred while creating admin";
    public static final String ADMIN_NOT_FOUND_MSG = "Admin is not found";

    public static final String APPLICANT_NOT_FOUND_CODE = "APPLICANT_NOT_FOUND";
    public static final String APPLICANT_NOT_FOUND_MSG = "Applicant is not found";

    // JWT / Security
    public static final String INVALID_TOKEN_CODE = "INVALID_TOKEN";
    public static final String INVALID_TOKEN_MSG = "Token is invalid or expired";
    public static final String UNAUTHORIZED_CODE = "UNAUTHORIZED";
    public static final String UNAUTHORIZED_MSG = "Authentication is required to access this resource";
    public static final String UNEXPECTED_ERROR_CODE = "UNEXPECTED_ERROR";
    public static final String UNEXPECTED_ERROR_MSG = "An unexpected error occurred";
    public static final String VALIDATION_ERROR_CODE = "VALIDATION_ERROR";

    public static final String COUNTRY_DELETE_ERROR_CODE = "COUNTRY_DELETE_ERROR";
    public static final String COUNTRY_DELETE_ERROR_UNI_MSG = "Before deleting country you should delete universities belonging to that country";

    public static final String WEB_PROPERTY_NOT_FOUND_CODE = "WEB_PROPERTY_NOT_FOUND";
    public static final String WEB_PROPERTY_NOT_FOUND_MSG = "There is no web-property data found. Try to add one!";
    public static final String WEB_PROPERTY_ILLEGAL_ARGUMENT_CODE = "WEB_PROPERTY_ILLEGAL_ARGUMENT";
    public static final String WEB_PROPERTY_ILLEGAL_ARGUMENT_ADMISSION_MSG = "Successful Admission cannot be bigger than total admissions";
    public static final String WEB_PROPERTY_ILLEGAL_ARGUMENT_VISA_MSG = "Successful visa help cannot be bigger than total visa help";

    public static final String TOO_MANY_REQUEST_CODE = "TOO_MANY_REQUESTS";
    public static final String TOO_MANY_REQUEST_GAME_MSG = "You made too many requests for game, wait a little bit";
    public static final String PARTICIPANT_NOT_FOUND_CODE = "PARTICIPANT_NOT_FOUND";
    public static final String PARTICIPANT_NOT_FOUND_MSG = "Participant not found";
    public static final String RESULT_NOT_FOUND_CODE = "RESULT_NOT_FOUND";
    public static final String RESULT_NOT_FOUND_MSG = "Result Not Found";
    public static final String SPIN_PLAY_ERROR = "SPIN_PLAY_ERROR";
    public static final String SPIN_PLAY_WAIT_MSG = "You need to wait at least 6 months to play another game";
    public static final String SPIN_PLAY_WEIGHT_ZERO_MSG = "Prize weights are invalid, Weight cannot be less than 0";
    public static final String SPIN_PLAY_WEIGHT_HUNDRED_MSG = "Prize weights are invalid, Weight cannot be more than 100";

    public static final String TOTAL_WEIGHT_MSG = "Total Weight cannot exceed 100. Try to remove another prize, or reduce the prize weight. Current Weight: ";
    public static final String TOTAL_WEIGHT_CODE = "TOTAL_WEIGHT_ERROR";

    public static final String PRIZE_ALREADY_EXISTS_CODE = "PRIZE_ALREADY_EXISTS";
    public static final String PRIZE_ALREADY_EXISTS_MSG = "Prize with this name already exists";

    public static final String PRIZE_NOT_FOUND_CODE = "PRIZE_NOT_FOUND";
    public static final String PRIZE_NOT_FOUND_MSG = "Prize not found";

    public static final String AD_ALREADY_EXISTS_CODE = "AD_ALREADY_EXISTS";
    public static final String AD_ALREADY_EXISTS_MSG = "Ad with this name already exists";

    public static final String AD_NOT_FOUND_CODE = "AD_NOT_FOUND";
    public static final String AD_NOT_FOUND_MSG = "Ad not found";

    public static final String AD_UPLOAD_ERROR_CODE = "AD_UPLOAD_ERROR";
    public static final String AD_UPLOAD_ERROR_MSG = "An error occurred while uploading the add";

}
