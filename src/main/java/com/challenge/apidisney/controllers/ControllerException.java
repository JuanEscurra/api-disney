package com.challenge.apidisney.controllers;

import com.challenge.apidisney.utils.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleEntityNotFound(Exception ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .title(ex.getClass().getSimpleName())
                .status(404)
                .URI(request.getRequestURI())
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {

        ErrorResponse error = ErrorResponse.builder()
                .title(ex.getClass().getSimpleName())
                .URI(request.getRequestURI())
                .status(400)
                .detail(MessageFormat
                        .format("Se requiere enviar un variable de tipo {0}, y no de tipo {1} ({2})",
                        ex.getRequiredType().getSimpleName(),
                        ex.getValue().getClass().getSimpleName(),
                        ex.getValue()))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PropertyValueException.class})
    protected ResponseEntity<ErrorResponse> handleDataIntegrationViolation(PropertyValueException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .title(ex.getClass().getSimpleName())
                .URI(request.getRequestURI())
                .status(400)
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<?> handleArgumentNotvalid(MethodArgumentNotValidException ex, HttpServletRequest request) throws JsonProcessingException {
        Map<String, String> fielderrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            fielderrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse error = ErrorResponse.builder()
                .title(ex.getClass().getSimpleName())
                .URI(request.getRequestURI())
                .status(400)
                .detail(fielderrors)
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataIntegratityVioletation(
            DataIntegrityViolationException ex, HttpServletRequest request) {
        System.out.println("dataIntegrationVioletationException");
        ErrorResponse error = ErrorResponse.builder()
                .title(ex.getClass().getSimpleName())
                .URI(request.getRequestURI())
                .status(400)
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
