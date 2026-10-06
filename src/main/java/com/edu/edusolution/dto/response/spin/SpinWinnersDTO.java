package com.edu.edusolution.dto.response.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpinWinnersDTO {
    @JsonProperty("email")
    private String email;
    @JsonProperty("prize_id")
    private UUID prizeId;
    @JsonProperty("prize")
    private String prize;
}
