package com.expense.splitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // If an exception is of type DuplicateResourceException or anything that extends it, use this handler.
    // Parent and childrens both are caught here..
    @ExceptionHandler(DuplicateResourceException.class)
    private ResponseEntity<Map<String, String>> handleDuplicateResourceException(DuplicateResourceException duplicateResourceException) {
        Map<String, String> error = new HashMap<>();
        error.put("message", duplicateResourceException.getMessage());
        return new ResponseEntity<Map<String, String>>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        Map<String, String> error = new HashMap<>();
        error.put("message", resourceNotFoundException.getMessage());
        return new ResponseEntity<Map<String, String>>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException runtimeException) {
        Map<String, String> error = new HashMap<>();
        error.put("message", runtimeException.getMessage());
        return new ResponseEntity<Map<String, String>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<Map<String, String>>(errors, HttpStatus.CONFLICT);
    }
}

