package com.example.crud_operations.exceptions;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles Jakarta Bean Validation errors (e.g., @NotBlank, @Email)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationErrors(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, "Invalid request content.");
        
        problem.setTitle("Validation Failed");
        problem.setType(URI.create("api.notifications.com"));
        
        // Collect all field-specific errors
        var errors = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(err -> err.getField(), err -> err.getDefaultMessage()));
        
        problem.setProperty("invalid_fields", errors);
        return problem;
    }

    /**
     * Handles custom business logic errors (e.g., NotificationProviderDown)
     */
    @ExceptionHandler(NotificationException.class)
    public ProblemDetail handleNotificationError(NotificationException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
    }
}