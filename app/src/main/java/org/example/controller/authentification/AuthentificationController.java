package org.example.controller.authentification;

import org.example.controller.authentification.dto.LoginRequestDto;
import org.example.controller.authentification.dto.LoginResponseDto;
import org.example.controller.authentification.dto.mapper.LoginRequestToLoginServiceInputMapper;
import org.example.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login (@RequestBody @Valid final LoginRequestDto input) {

        final var aServiceInput = LoginRequestToLoginServiceInputMapper.build().apply(input);

        final var aToken = authService.login(aServiceInput).token();

        final var aResponse = new LoginResponseDto(aToken);

        return ResponseEntity.ok(aResponse);
       
    }
    
}
