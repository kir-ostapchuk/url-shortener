package com.ostapchuk.url.shortener.exception;

public class UrlValidationException extends RuntimeException {

    public UrlValidationException(final String message) {
        super(message);
    }
}
