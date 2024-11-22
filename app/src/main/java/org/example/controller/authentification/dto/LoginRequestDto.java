package org.example.controller.authentification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record LoginRequestDto(
    @NotBlank(message = "campo E-mail não pode estar vazio")
    @Email( message = "E-mail invalido") String email,
    @NotBlank(message = "campo senha não -pode estar vazio") String password
) {
    
}
