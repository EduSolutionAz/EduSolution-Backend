package com.edu.edusolution.dto.response;

import com.edu.edusolution.entity.client.PendingState;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientRegisterResponseDTO {
    private String clientEmail;
    private boolean codeSent;
    private PendingState registerStatus;
}
