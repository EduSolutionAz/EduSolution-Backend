package com.edu.edusolution.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class LoginResponse {

    private String token;
    private long expiresIn;
}
