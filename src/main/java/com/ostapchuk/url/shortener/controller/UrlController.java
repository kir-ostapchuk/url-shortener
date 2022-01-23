package com.ostapchuk.url.shortener.controller;

import com.ostapchuk.url.shortener.dto.UrlDto;
import com.ostapchuk.url.shortener.exception.UrlValidationException;
import com.ostapchuk.url.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ostapchuk.url.shortener.util.Constant.HTTP;
import static com.ostapchuk.url.shortener.util.Constant.HTTPS;
import static com.ostapchuk.url.shortener.util.Constant.URL_VALIDATION_MSG;

@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{id}")
    public String findById(@PathVariable final String id) {
        return urlService.findById(id);
    }

    @PostMapping
    public String save(@RequestBody final UrlDto url) {
        final UrlValidator validator = new UrlValidator(new String[]{HTTP, HTTPS});
        if (!validator.isValid(url.getUrl())) {
            throw new UrlValidationException(URL_VALIDATION_MSG + url.getUrl());
        }
        return urlService.save(url.getUrl());
    }
}
