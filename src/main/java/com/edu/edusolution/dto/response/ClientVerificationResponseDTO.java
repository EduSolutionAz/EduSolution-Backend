package com.edu.edusolution.dto.response;

import com.edu.edusolution.entity.client.PendingState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientVerificationResponseDTO {
    @JsonProperty("email")
    private String clientEmail;
    @JsonProperty("is_verified")
    private boolean isVerified;
    @JsonProperty("status")
    private PendingState status;
}
