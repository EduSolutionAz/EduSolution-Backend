package com.edu.edusolution.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.edu.edusolution.constants.DtoConstants.IS_DELETED_JSON;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaqDeleteResponseDTO {
    @JsonProperty(IS_DELETED_JSON)
    private Boolean isDeleted;
}
