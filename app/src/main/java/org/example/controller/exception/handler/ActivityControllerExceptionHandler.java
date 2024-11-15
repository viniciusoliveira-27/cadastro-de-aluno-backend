package org.example.controller.exception.handler;

import org.example.domain.activity.exceptions.DomainException;
import org.example.repository.exception.PersistenceException;
import org.example.service.activity.exception.ServiceException;
import org.example.utils.InstantUtils;
import org.example.controller.exception.handler.body.ExceptionResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ActivityControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DomainException.class})
    protected ResponseEntity<ExceptionResponseBody> handleDomainException(final DomainException anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.BAD_REQUEST.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.badRequest().body(aBody);        
    }

    @ExceptionHandler(value = {PersistenceException.class})
    protected ResponseEntity<ExceptionResponseBody> handleDomainException(final PersistenceException anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.internalServerError().body(aBody);        
    }

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<ExceptionResponseBody> handleDomainException(final ServiceException anException, final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.BAD_REQUEST.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

            return ResponseEntity.badRequest().body(aBody);        
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
