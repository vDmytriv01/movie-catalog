package com.team200.moviecatalog.exception;

import com.team200.moviecatalog.constants.ErrorMessages;
import io.jsonwebtoken.JwtException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(EntityNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, "NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(com.team200.moviecatalog.exception.EntityNotFoundException.class)
    public ResponseEntity<Object> handleCustomNotFound(
            com.team200.moviecatalog.exception.EntityNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, "NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflict(ConflictException ex) {
        return buildError(HttpStatus.CONFLICT, "CONFLICT", ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
        return buildError(HttpStatus.BAD_REQUEST, "BAD_REQUEST", ex.getMessage());
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<Object> handleRegistration(RegistrationException ex) {
        return buildError(HttpStatus.BAD_REQUEST, "REGISTRATION_ERROR", ex.getMessage());
    }

    @ExceptionHandler(FileStorageException.class)
    public ResponseEntity<Object> handleFileStorage(FileStorageException ex) {
        HttpStatus status = ex.getCause() instanceof IOException
                ? HttpStatus.INTERNAL_SERVER_ERROR
                : HttpStatus.BAD_REQUEST;

        return buildError(status, "FILE_STORAGE_ERROR", ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(v -> v.getMessage())
                .orElse("Invalid input");

        return buildError(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", message);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrity(DataIntegrityViolationException ex) {
        return buildError(
                HttpStatus.CONFLICT,
                "DATA_INTEGRITY_ERROR",
                ErrorMessages.DATA_INTEGRITY_VIOLATION
        );
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<Object> handleJwt(JwtException ex) {
        return buildError(HttpStatus.UNAUTHORIZED,
                "INVALID_TOKEN",
                ErrorMessages.INVALID_AUTH_TOKEN);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthentication(AuthenticationException ex) {
        return buildError(HttpStatus.UNAUTHORIZED,
                "INVALID_CREDENTIALS",
                ErrorMessages.INVALID_EMAIL_OR_PASSWORD);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex) {
        return buildError(HttpStatus.FORBIDDEN,
                "ACCESS_DENIED",
                ErrorMessages.ACCESS_DENIED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception ex) {
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_ERROR",
                "Internal server error");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid value for parameter '" + ex.getName() + "'";
        return buildError(HttpStatus.BAD_REQUEST, "BAD_REQUEST", message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        String message = extractFirstValidationMessage(ex);

        return buildError(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", message);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        return buildError(HttpStatus.BAD_REQUEST,
                "BAD_REQUEST",
                ErrorMessages.MALFORMED_JSON);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        String message = "Required parameter '" + ex.getParameterName() + "' is missing";
        return buildError(HttpStatus.BAD_REQUEST, "BAD_REQUEST", message);
    }

    private String extractFirstValidationMessage(MethodArgumentNotValidException ex) {
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                return fieldError.getDefaultMessage();
            }
            return error.getDefaultMessage();
        }
        return "Invalid input data";
    }

    private ResponseEntity<Object> buildError(HttpStatus status, String errorCode, String message) {
        return new ResponseEntity<>(ErrorResponseFactory.build(status, errorCode, message), status);
    }
}
