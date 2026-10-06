package com.edu.edusolution.dto.response.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrizeSendResponseDTO {
    @JsonProperty("is_sent")
    private Boolean isSent;
}
