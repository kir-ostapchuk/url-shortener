package com.ostapchuk.url.shortener.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({UrlValidationException.class, UrlNotFoundException.class})
    public String handle(final RuntimeException e) {
        return e.getMessage();
    }
}
