package org.example.controller.authentification.dto.mapper;

import java.util.function.Function;

import org.example.controller.authentification.dto.LoginRequestDto;
import org.example.service.auth.dto.LoginServiceInputDto;

public class LoginRequestToLoginServiceInputMapper implements Function<LoginRequestDto, LoginServiceInputDto>  {

    public static LoginRequestToLoginServiceInputMapper build() {
        return new LoginRequestToLoginServiceInputMapper();
    }

    @Override
    public LoginServiceInputDto apply(final LoginRequestDto input) {
        return new LoginServiceInputDto(input.email(),input.password());


    }
    
}
