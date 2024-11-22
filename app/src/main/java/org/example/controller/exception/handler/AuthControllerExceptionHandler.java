package org.example.controller.exception.handler;

import org.example.controller.exception.handler.body.ExceptionResponseBody;
import org.example.service.auth.exception.AuthException;
import org.example.service.auth.exception.LoginException;
import org.example.utils.InstantUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice("org.example.controller.authentication")
public class AuthControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {LoginException.class})
    protected ResponseEntity<ExceptionResponseBody> handleLoginException(final LoginException anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.BAD_REQUEST.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.badRequest().body(aBody);        
    }

    @ExceptionHandler(value = {AuthException.class})
    protected ResponseEntity<ExceptionResponseBody> handleAuthException(final AuthException anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.internalServerError().body(aBody);        
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ExceptionResponseBody> handleDomainException(final Exception anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.internalServerError().body(aBody);        
    }
    
}
