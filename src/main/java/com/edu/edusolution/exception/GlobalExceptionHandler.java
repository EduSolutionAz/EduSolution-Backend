package com.edu.edusolution.exception;

import com.edu.edusolution.dto.response.exception.ExceptionResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

import static com.edu.edusolution.constants.ExceptionConstants.DATA_INTEGRITY_PROBLEM_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.UNAUTHORIZED_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.UNAUTHORIZED_MSG;
import static com.edu.edusolution.constants.ExceptionConstants.UNEXPECTED_ERROR_CODE;
import static com.edu.edusolution.constants.ExceptionConstants.UNEXPECTED_ERROR_MSG;
import static com.edu.edusolution.constants.ExceptionConstants.VALIDATION_ERROR_CODE;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientAlreadyExistsException(ClientAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(MailSendingException.class)
    public ResponseEntity<ExceptionResponseDTO> handleMailSendingException(MailSendingException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ClientAlreadyVerifiedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAlreadyVerifiedException(ClientAlreadyVerifiedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ClientNotVerifiedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotVerifiedException(ClientNotVerifiedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(VerificationFailedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleVerificationFailedException(VerificationFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(DATA_INTEGRITY_PROBLEM_CODE, ex.getMessage()));
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCountryNotFoundException(CountryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(CountryAlreadyExists.class)
    public ResponseEntity<ExceptionResponseDTO> handleCountryAlreadyExistsException(CountryAlreadyExists ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(CountryUploadException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCountryUploadExistsException(CountryUploadException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(DataDeleteException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDataDeleteExistsException(DataDeleteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(DataInsertException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDataInsertExistsException(DataInsertException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(UniversityAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleUniversityAlreadyExistsException(UniversityAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleUniversityNotFoundException(UniversityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleTokenNotFoundException(TokenNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ExceptionResponseDTO> handleEmailException(EmailException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(FacultyAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleFacultyAlreadyExistsException(FacultyAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleFacultyNotFoundException(FacultyNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAdminNotFoundException(AdminNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(AdminCreationException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAdminCreationException(AdminCreationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleApplicantNotFoundException(ApplicantNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(WebPropertyNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleWebPropertyNotFoundException(WebPropertyNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(WebPropertyArgumentException.class)
    public ResponseEntity<ExceptionResponseDTO> handleWebArgumentFoundException(WebPropertyArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionResponseDTO(UNAUTHORIZED_CODE, UNAUTHORIZED_MSG));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(VALIDATION_ERROR_CODE, message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleUnexpectedException(Exception ex) {
        log.error("Unexpected error occurred", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponseDTO(UNEXPECTED_ERROR_CODE, UNEXPECTED_ERROR_MSG));
    }

    @ExceptionHandler(ParticipantNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleParticipantNotFoundException(ParticipantNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(PrizeAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handlePrizeAlreadyExistsException(PrizeAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(PrizeNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handlePrizeNotFoundException(PrizeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResultNotFoundException(ResultNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(SpinGamePlayException.class)
    public ResponseEntity<ExceptionResponseDTO> handleSpinGamePlayException(SpinGamePlayException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleTooManyRequestsException(TooManyRequestsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(TotalWeightException.class)
    public ResponseEntity<ExceptionResponseDTO> handleTotalWeightException(TotalWeightException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(), ex.getMessage()));
    }

}
