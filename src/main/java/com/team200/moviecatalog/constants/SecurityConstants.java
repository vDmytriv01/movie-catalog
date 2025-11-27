package com.team200.moviecatalog.constants;

import org.springframework.http.HttpHeaders;

public final class SecurityConstants {

    public static final String BEARER_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = HttpHeaders.AUTHORIZATION;

    private SecurityConstants() {
    }
}
