package com.edu.edusolution.dto.request.spin;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpinCheckRequestDTO {

    @JsonProperty(BROWSER_ID_JSON) //38
    @Size(max = BROWSER_ID_LENGTH, message = BROWSER_ID_LENGTH_MSG)
    private UUID browserId;
    @JsonProperty("ip")
    private String ip;
}
