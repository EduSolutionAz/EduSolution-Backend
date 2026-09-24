package com.edu.edusolution.constants;

import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

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
    public static final String NAME_IS_REQUIRED_NULL_MSG = "Name is required to proceed. Name cannot be null";
    public static final String NAME_IS_REQUIRED_BLANK_MSG = "Name is required to proceed. Name cannot be blank";
    public static final String NAME_LENGTH_MSG = "Name must not exceed 50 characters";
    public static final String NAME_FULL_LENGTH_MSG = "Name must not exceed 100 characters";
    public static final String NAME_JSON_FIELD = "name";

    public static final String PHONE_IS_REQUIRED_MSG = "Phone is required to proceed";
    public static final String PHONE_LENGTH_MSG = "Phone must not exceed 15 characters or less than 12 characters";
    public static final String PHONE_JSON_FIELD = "phone";

    public static final String CODE_IS_REQUIRED_MSG = "CODE is required to proceed";
    public static final String CODE_LENGTH_MSG = "CODE must be 6 characters";
    public static final String CODE_JSON_FIELD = "code";

    public static final String COUNTRY_IS_REQUIRED_NULL_MSG = "Country cannot be null";
    public static final String COUNTRY_IS_REQUIRED_BLANK_MSG = "Country cannot be blank";
    public static final String COUNTRY_LENGTH_MSG = "Country name cannot exceed 50 characters";

    public static final String COMMENT_IS_REQUIRED_NULL_MSG = "Comment cannot be null";
    public static final String COMMENT_IS_REQUIRED_BLANK_MSG = "Comment cannot be blank";
    public static final String COMMENT_SIZE_MSG = "Comment cannot be less than 20 characters and more than 256 characters";

    public static final String SERVICE_IS_REQUIRED_NULL_MSG = "Service type cannot be null";
    public static final String SERVICE_IS_REQUIRED_BLANK_MSG = "Service type cannot be blank";

    public static final String UNIVERSITY_IS_REQUIRED_NULL_MSG = "University cannot be null";
    public static final String UNIVERSITY_IS_REQUIRED_BLANK_MSG = "University cannot be blank";
    public static final String UNIVERSITY_SIZE_MSG = "University name cannot exceed 75 characters";
    public static final String UNIVERSITY_JSON = "university_name";

    public static final String UNIVERSITY_TYPE_IS_REQUIRED_NULL_MSG = "University cannot be null";
    public static final String UNIVERSITY_TYPE_IS_REQUIRED_BLANK_MSG = "University type cannot be blank";

    public static final String DESCRIPTION_IS_REQUIRED_NULL_MSG = "Description cannot be null";
    public static final String DESCRIPTION_IS_REQUIRED_BLANK_MSG = "Description cannot be blank";

    public static final String UNIVERSITY_LOGO_IS_REQUIRED_NULL_MSG = "University Logo cannot be null";
    public static final String UNIVERSITY_LOGO_IS_REQUIRED_BLANK_MSG = "University Logo cannot be blank";

    public static final String CITY_IS_REQUIRED_NULL_MSG = "City cannot be null";
    public static final String CITY_IS_REQUIRED_BLANK_MSG = "City cannot be blank";

    public static final String CONTENT_IS_REQUIRED_NULL_MSG = "Content cannot be null";
    public static final String CONTENT_IS_REQUIRED_BLANK_MSG = "Content cannot be blank";

    public static final String AREA_IS_REQUIRED_NULL_MSG = "Area cannot be null";
    public static final String AREA_IS_REQUIRED_BLANK_MSG = "Area cannot be blank";

    public static final String FLAG_IS_REQUIRED_NULL_MSG = "Flag cannot be null";
    public static final String FLAG_IS_REQUIRED_BLANK_MSG = "Flag cannot be blank";

    public static final String COUNTRY_IMAGE_IS_REQUIRED_NULL_MSG = "Country Image cannot be null";
    public static final String COUNTRY_IMAGE_IS_REQUIRED_BLANK_MSG = "Country Image cannot be blank";

    public static final String UNIVERSITY_COUNT_IS_REQUIRED_NULL_MSG = "University Count cannot be null";
    public static final String UNIVERSITY_COUNT_IS_REQUIRED_BLANK_MSG = "University Count cannot be blank";

    public static final String TUITION_IS_REQUIRED_NULL_MSG = "Tuition fee cannot be null";
    public static final String TUITION_IS_REQUIRED_BLANK_MSG = "Tuition fee cannot be blank";

    public static final String RENTAL_IS_REQUIRED_NULL_MSG = "Rental fee cannot be null";
    public static final String RENTAL_IS_REQUIRED_BLANK_MSG = "Rental fee cannot be blank";

    public static final String VISA_HELP_IS_REQUIRED_NULL_MSG = "Visa Help cannot be null";
    public static final String VISA_HELP_IS_REQUIRED_BLANK_MSG = "Visa Help cannot be blank";

    public static final String DORMITORY_HELP_IS_REQUIRED_NULL_MSG = "Dormitory Help cannot be null";
    public static final String DORMITORY_HELP_IS_REQUIRED_BLANK_MSG = "Dormitory Help cannot be blank";

    public static final String TOKEN_LENGTH_MSG = "Token must be exactly 36 characters";
    public static final String TOKEN_IS_REQUIRED_NULL_MSG = "Token cannot be null";
    public static final String TOKEN_IS_REQUIRED_BLANK_MSG = "Token cannot be blank";

    public static final String FACULTY_IS_REQUIRED_NULL_MSG = "Faculty cannot be null";
    public static final String FACULTY_IS_REQUIRED_BLANK_MSG = "Faculty cannot be blank";
    public static final String FACULTY_JSON = "faculty_name";

    public static final String IS_CREATED_JSON = "is_created";
    public static final String IS_DELETED_JSON = "is_deleted";



}
