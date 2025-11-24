package com.team200.moviecatalog.exception;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, Object> body = baseBody(status.value(), "VALIDATION_ERROR");
        body.put("message", "Invalid input data");

        Map<String, String> details = new LinkedHashMap<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                details.put(fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                details.put(error.getObjectName(), error.getDefaultMessage());
            }
        }

        body.put("details", details);

        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(EntityNotFoundException ex) {
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
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "FILE_STORAGE_ERROR", ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        return buildError(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrity(DataIntegrityViolationException ex) {
        String rootMessage = ex.getMostSpecificCause().getMessage();
        return buildError(HttpStatus.BAD_REQUEST, "DATA_INTEGRITY_ERROR", rootMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception ex) {
        return buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_ERROR",
                "Internal server error"
        );
    }

    private ResponseEntity<Object> buildError(
            HttpStatus status,
            String errorCode,
            String message
    ) {
        Map<String, Object> body = baseBody(status.value(), errorCode);
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }

    private Map<String, Object> baseBody(int status, String errorCode) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status);
        body.put("error", errorCode);
        return body;
    }
}
