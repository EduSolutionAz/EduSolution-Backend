package com.edu.edusolution.dto.response;

import com.edu.edusolution.entity.client.PendingState;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientVerificationResponseDTO {
    private String clientEmail;
    private boolean isVerified;
    private PendingState status;
}
