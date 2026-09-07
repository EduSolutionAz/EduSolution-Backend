package com.edu.edusolution.exception;

import com.edu.edusolution.dto.response.exception.ExceptionResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.edu.edusolution.constants.ExceptionConstants.DATA_INTEGRITY_PROBLEM_CODE;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientAlreadyExistsException(ClientAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(MailSendingException.class)
    public ResponseEntity<ExceptionResponseDTO> handleMailSendingException(MailSendingException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(ClientAlreadyVerifiedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAlreadyVerifiedException(ClientAlreadyVerifiedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotFoundException(ClientNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(ClientNotVerifiedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotVerifiedException(ClientNotVerifiedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(VerificationFailedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleVerificationFailedException(VerificationFailedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(ex.getCode(),ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(DATA_INTEGRITY_PROBLEM_CODE,ex.getMessage()));
    }
}
