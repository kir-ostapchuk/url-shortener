package com.ostapchuk.url.shortener.exception;

public class UrlNotFoundException extends RuntimeException {

    public UrlNotFoundException(final String message) {
        super(message);
    }
}
