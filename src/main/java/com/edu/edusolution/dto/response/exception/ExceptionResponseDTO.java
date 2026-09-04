package com.edu.edusolution.dto.response.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String code;
    private String message;
}
