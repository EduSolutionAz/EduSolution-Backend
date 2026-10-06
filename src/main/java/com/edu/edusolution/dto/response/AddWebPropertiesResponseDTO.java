package com.edu.edusolution.dto.response;

import com.edu.edusolution.dto.ErrorDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.edu.edusolution.constants.DtoConstants.IS_CREATED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddWebPropertiesResponseDTO {

    @JsonProperty(IS_CREATED_JSON)
    private Boolean isCreated;

    private List<ErrorDto> errors;
}
