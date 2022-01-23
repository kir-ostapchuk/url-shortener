package com.ostapchuk.url.shortener.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    // Protocols
    public static final String HTTP = "http";

    public static final String HTTPS = "https";

    // Exception messages
    public static final String URL_VALIDATION_MSG = "Could not shorten. The url is invalid: ";

    public static final String URL_NOT_FOUND_MSG = "Could not find the shortened url by the id: ";

    // Literals
    public static final String SLASH = "/";

}
