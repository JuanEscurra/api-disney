package com.challenge.apidisney.controllers;

import com.challenge.apidisney.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleEntityNotFound(
            Exception ex, HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(ex.getClass().getSimpleName(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
