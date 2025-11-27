package com.team200.moviecatalog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team200.moviecatalog.constants.ErrorMessages;
import com.team200.moviecatalog.exception.ErrorResponseFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException {

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");

        Map<String, Object> body = ErrorResponseFactory.build(
                HttpStatus.FORBIDDEN,
                "ACCESS_DENIED",
                ErrorMessages.ACCESS_DENIED
        );

        mapper.writeValue(response.getWriter(), body);
    }
}
