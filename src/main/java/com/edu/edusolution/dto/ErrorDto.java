package com.edu.edusolution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorDto {
    @JsonProperty("Error_Message")
    String errorMsg;
}
