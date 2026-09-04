package com.edu.edusolution.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterMessageDTO {
    String message;
    String code;
}
