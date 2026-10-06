package com.edu.edusolution.exception;

import static com.edu.edusolution.constants.ExceptionConstants.*;

public class AdUploadException extends BaseApplicationException {
    public AdUploadException() {
        super(AD_UPLOAD_ERROR_CODE, AD_UPLOAD_ERROR_MSG);
    }
}
