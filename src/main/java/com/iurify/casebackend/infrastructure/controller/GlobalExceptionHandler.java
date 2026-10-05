package com.iurify.casebackend.infrastructure.controller;

import com.iurify.casebackend.application.exception.ResourceNotFoundException;
import com.iurify.casebackend.infrastructure.controller.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDto error = new ErrorDto(
                "CASE_NOT_FOUND",
                ex.getMessage(),
                UUID.randomUUID().toString().replace("-", ""),
                false
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
