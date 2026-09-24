package com.edu.edusolution.dto.response;

import com.edu.edusolution.entity.client.PendingState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientRegisterResponseDTO {
    @JsonProperty("email")
    private String clientEmail;
    @JsonProperty("is_code_sent")
    private boolean codeSent;
    @JsonProperty("register_status")
    private PendingState registerStatus;
}
