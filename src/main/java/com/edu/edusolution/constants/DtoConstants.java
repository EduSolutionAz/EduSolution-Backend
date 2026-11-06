package com.edu.edusolution.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoConstants {
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[.,#?/]).+$";
    public static final String PASSWORD_REGEX_MSG = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character (.,#?/)";

    // Length Values & Min Max Values
    public static final int BROWSER_ID_LENGTH = 45;
    public static final String BROWSER_ID_LENGTH_MSG ="Browser ID cannot exceed 45 characters";
    public static final int PRIZE_WEIGHT_MIN = 0;
    public static final int PRIZE_WEIGHT_MAX = 100;
    public static final int PRIZE_NAME_LENGTH = 50;
    public static final String PRIZE_NAME_LENGTH_MSG = "Prize name cannot exceed 50 character";
    public static final String USERNAME_LENGTH_MSG = "username can be max 25 characters";
    public static final String COUNTRY_LENGTH_MSG = "Country name cannot exceed 50 characters";
    public static final String COMMENT_SIZE_MSG = "Comment cannot be less than 20 characters and more than 256 characters";
    public static final String NAME_LENGTH_MSG = "Name must not exceed 50 characters";
    public static final String UNIVERSITY_SIZE_MSG = "University name cannot exceed 75 characters";
    public static final String TOKEN_LENGTH_MSG = "Token must be exactly 36 characters";
    public static final String CODE_LENGTH_MSG = "CODE must be 6 characters";
    public static final String PHONE_LENGTH_MSG = "Phone must not exceed 15 characters or less than 9 characters";
    public static final String NAME_FULL_LENGTH_MSG = "Name must not exceed 100 characters";
    public static final String PASSWORD_LENGTH_MSG = "Password must not exceed 30 characters and less than 9 characters";
    public static final String EMAIL_LENGTH_MSG = "Email must not exceed 75 characters";


    // NOT NULL & BLANK VALUES
    public static final String SEMESTER_COUNT_NULL_MSG = "Semester Count cannot be null";
    public static final String SEMESTER_COUNT_BLANK_MSG = "Semester count cannot be blank";
    public static final String PRIZE_NAME_NOT_NULL = "Prize name cannot be null";
    public static final String PRIZE_NAME_BLANK = "Prize name cannot be blank";
    public static final String SUCCESSFUL_VISA_HELP_NULL_MSG = "Number of successful visa help cannot be null";
    public static final String SUCCESSFUL_VISA_HELP_BLANK_MSG = "Number of successful visa help cannot be blank";
    public static final String VISA_HELP_NULL_MSG = "Number of visa help cannot be null";
    public static final String VISA_HELP_BLANK_MSG = "Number of visa help cannot be blank";
    public static final String SUCCESSFUL_ADMISSION_NULL_MSG = "Number of successful admissions cannot be null";
    public static final String SUCCESSFUL_ADMISSION_BLANK_MSG = "Number of successful admissions cannot be blank";
    public static final String ADMISSION_SENT_NULL_MSG = "Number of admissions sent cannot be null";
    public static final String ADMISSION_SENT_BLANK_MSG = "Number of admissions sent cannot be blank";
    public static final String STUDENTS_HELP_NULL_MSG = "Number of students helped cannot be null";
    public static final String STUDENTS_HELP_BLANK_MSG = "Number of students helped cannot be blank";
    public static final String FEE_IS_REQUIRED_NULL_MSG = "Fee cannot be null";
    public static final String FEE_IS_REQUIRED_BLANK_MSG = "Fee cannot be blank";
    public static final String FACULTY_IS_REQUIRED_NULL_MSG = "Faculty cannot be null";
    public static final String FACULTY_IS_REQUIRED_BLANK_MSG = "Faculty cannot be blank";
    public static final String TOKEN_IS_REQUIRED_NULL_MSG = "Token cannot be null";
    public static final String TOKEN_IS_REQUIRED_BLANK_MSG = "Token cannot be blank";
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
    public static final String ICON_IS_REQUIRED_NULL_MSG = "icon cannot be null";
    public static final String ICON_IS_REQUIRED_BLANK_MSG = "icon cannot be blank";
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
    public static final String TOP_IS_REQUIRED_NULL_MSG = "Top cannot be null";
    public static final String TOP_IS_REQUIRED_BLANK_MSG = "Top cannot be blank";
    public static final String PARTNER_IS_REQUIRED_NULL_MSG = "Partner cannot be null";
    public static final String PARTNER_IS_REQUIRED_BLANK_MSG = "Partner cannot be blank";
    public static final String EMAIL_IS_REQUIRED_MSG = "Email is required to proceed";
    public static final String PASSWORD_IS_REQUIRED_MSG = "Password is required to proceed";
    public static final String NAME_IS_REQUIRED_MSG = "Name is required to proceed";
    public static final String NAME_IS_REQUIRED_NULL_MSG = "Name is required to proceed. Name cannot be null";
    public static final String NAME_IS_REQUIRED_BLANK_MSG = "Name is required to proceed. Name cannot be blank";
    public static final String PHONE_IS_REQUIRED_MSG = "Phone is required to proceed";
    public static final String CODE_IS_REQUIRED_MSG = "CODE is required to proceed";
    public static final String COUNTRY_IS_REQUIRED_NULL_MSG = "Country cannot be null";
    public static final String COUNTRY_IS_REQUIRED_BLANK_MSG = "Country cannot be blank";
    public static final String COMMENT_IS_REQUIRED_NULL_MSG = "Comment cannot be null";
    public static final String COMMENT_IS_REQUIRED_BLANK_MSG = "Comment cannot be blank";
    public static final String SERVICE_IS_REQUIRED_NULL_MSG = "Service type cannot be null";
    public static final String SERVICE_IS_REQUIRED_BLANK_MSG = "Service type cannot be blank";

    public static final String UNIVERSITY_IS_REQUIRED_NULL_MSG = "University cannot be null";
    public static final String UNIVERSITY_IS_REQUIRED_BLANK_MSG = "University cannot be blank";

    // JSON VALUES
    public static final String COUNTRY_NAME_JSON = "country_name";
    public static final String UNIVERSITY_NAME_JSON = "university_name";

    public static final String FLAG_IMG_JSON = "flag_image";
    public static final String COUNTRY_IMG_JSON = "country_image";
    public static final String UNIVERSITY_COUNT_JSON = "university_count";
    public static final String TUITION_FEE_JSON = "tuition_fee";
    public static final String RENTAL_FEE_JSON = "rental_fee";
    public static final String MONTHLY_SPENDING_JSON = "monthly_spending";
    public static final String IS_VISA_HELP_JSON = "is_visa_help";
    public static final String IS_DORM_HELP_JSON = "is_dormitory_help";
    public static final String DORM_HELP_JSON = "dormitory_help";
    public static final String IS_TOP_LIST_JSON = "is_top_list";
    public static final String CONTENT_JSON = "content";
    public static final String AREA_JSON = "area";
    public static final String AREAS_JSON = "areas";
    public static final String ICON_JSON = "icon";
    public static final String IS_COUNTRY_CREATED_JSON = "is_country_created";
    public static final String IS_UPDATED_JSON = "is_updated";
    public static final String UNIVERSITY_TYPE_JSON = "university_type";
    public static final String FEE_JSON = "fee";
    public static final String CITY_JSON = "city";
    public static final String SHORT_DESC_JSON = "short_description";
    public static final String SEMESTER_COUNT_JSON = "semester_count";
    public static final String IS_PARTNER_JSON = "is_partner";

    public static final String COUNTRY_FLAG_URL_JSON = "country_flag_url";
    public static final String UNIVERSITY_LOGO_URL_JSON = "university_logo_url";
    public static final String PHOTO_URL_JSON = "photo_url";
    public static final String COUNTRY_BG_URL_JSON = "country_bg_url";
    public static final String UNIVERSITY_LOGO_JSON = "university_logo";
    public static final String TITLE_JSON = "title";
    public static final String UNIVERSITIES_JSON = "universities";
    public static final String UNIVERSITY_COST_JSON = "university_cost";
    public static final String EMAIL_VALID_MSG = "Email must be a valid email address";
    public static final String EMAIL_JSON_FIELD = "email";
    public static final String PASSWORD_JSON_FIELD = "password";
    public static final String NAME_JSON_FIELD = "name";
    public static final String PHONE_JSON_FIELD = "phone";
    public static final String CODE_JSON_FIELD = "code";
    public static final String UNIVERSITY_JSON = "university_name";
    public static final String FACULTY_JSON = "faculty_name";
    public static final String IS_CREATED_JSON = "is_created";
    public static final String IS_DELETED_JSON = "is_deleted";

    // Property Json
    public static final String STUDENTS_HELPED_JSON = "students_helped";
    public static final String ADMISSIONS_SENT_JSON = "admissions_sent";
    public static final String SUCCESSFUL_ADMISSION_JSON = "successful_admission";
    public static final String VISA_HELP_JSON = "visa_help";
    public static final String SUCCESSFUL_VISA_HELP_JSON = "successful_visa_help";
    public static final String VISA_SUCCESS_RATE_JSON = "visa_success_rate";
    public static final String PRIZE_NAME_JSON = "prize_name";
    public static final String PRIZE_WEIGHT_JSON = "prize_weight";
    public static final String BROWSER_ID_JSON = "browser_id";

    // FAQ Json
    public static final String FAQ_ID_JSON = "faq_id";
    public static final String FAQ_QUESTION_JSON = "faq_question";
    public static final String FAQ_ANSWER_JSON = "faq_answer";
    public static final String FAQ_TEXT_JSON = "faq_text";


}
