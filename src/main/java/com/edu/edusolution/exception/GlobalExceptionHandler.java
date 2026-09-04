package com.edu.edusolution.exception;

import com.edu.edusolution.dto.response.exception.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
