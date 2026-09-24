package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPasswordCreationResponseDTO {
    @JsonProperty("email")
    private String clientEmail;
    @JsonProperty("is_profile_created")
    private boolean isProfileCreated;
}
