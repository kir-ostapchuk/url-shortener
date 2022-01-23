package com.ostapchuk.url.shortener.service;

import com.google.common.hash.Hashing;
import com.ostapchuk.url.shortener.exception.UrlNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import static com.ostapchuk.url.shortener.util.Constant.SLASH;
import static com.ostapchuk.url.shortener.util.Constant.URL_NOT_FOUND_MSG;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlService {

    @Value("${APPLICATION_LINK}")
    private String applicationLink;

    private final StringRedisTemplate redisTemplate;

    public String findById(final String id) {
        final String url = redisTemplate.opsForValue().get(id);
        if (url == null) {
            throw new UrlNotFoundException(URL_NOT_FOUND_MSG + id);
        }
        log.info("Url retrieved: " + url);
        return url;
    }

    public String save(final String url) {
        final String id = Hashing.murmur3_32_fixed().hashUnencodedChars(url).toString();
        redisTemplate.opsForValue().set(id, url);
        log.info("Url id generated: " + id);
        return applicationLink + SLASH + id;
    }
}
