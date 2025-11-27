package com.team200.moviecatalog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team200.moviecatalog.constants.ErrorMessages;
import com.team200.moviecatalog.exception.ErrorResponseFactory;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        boolean invalidToken = authException.getCause() instanceof JwtException;
        String error = invalidToken ? "INVALID_TOKEN" : "UNAUTHORIZED";
        String message = invalidToken
                ? ErrorMessages.INVALID_AUTH_TOKEN
                : ErrorMessages.AUTHENTICATION_REQUIRED;

        Map<String, Object> body = ErrorResponseFactory.build(
                HttpStatus.UNAUTHORIZED, error, message);

        mapper.writeValue(response.getWriter(), body);
    }
}
