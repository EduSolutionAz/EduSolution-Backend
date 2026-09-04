package com.edu.edusolution.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPasswordCreationResponseDTO {
    private String clientEmail;
    private boolean isProfileCreated;
}
