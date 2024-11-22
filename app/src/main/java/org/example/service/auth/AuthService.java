package org.example.service.auth;

import org.example.domain.user.User;
import org.example.service.auth.dto.LoginServiceInputDto;
import org.example.service.auth.dto.LoginServiceOutputDto;
import org.example.service.auth.exception.AuthException;
import org.example.service.auth.exception.LoginException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class AuthService {

    //Usuario unico da aplicação
    final User uniqueUser = User.with("viniciusoliveira.270304@gmail.com", "Predator@27");

    private final String TOKEN_SECRET = "123456";

    private final String TOKEN_ISSUER = "org.example";

    public LoginServiceOutputDto login(final LoginServiceInputDto input) {
        final var anUser = User.with(input.email(),input.password());

        if(!uniqueUser.getEmail().equals(anUser.getEmail()) 
                || !uniqueUser.getPassword().equals(anUser.getPassword())) {
            throw new LoginException("User or password not found");

        }
        final var aToken = this.createToken(anUser); 

        return new LoginServiceOutputDto(aToken);
        
    }   
    
    private String createToken(final User anUser) {

        final var anAlgorithm = Algorithm.HMAC256(TOKEN_SECRET);


        try{
            final var aToken = JWT.create()
                .withIssuer(TOKEN_ISSUER)
                .withSubject(anUser.getEmail())
                .sign(anAlgorithm);

            return aToken;
        } catch(IllegalArgumentException e) {
            throw new AuthException(e.getMessage());
            
        } catch(JWTCreationException e) {
            throw new AuthException(e.getMessage());
        }
    }
}
