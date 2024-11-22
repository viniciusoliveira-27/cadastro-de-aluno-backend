package org.example.controller.authentification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ValidateResponseDto(
        @JsonProperty("is_valid") boolean isValid
) {
    
}
