package org.example.controller.authentification.dto;

import jakarta.validation.constraints.NotBlank;

public record ValidateRequestDto(
    @NotBlank(message = "token shoudn't be blank") String token ) {
    
}
