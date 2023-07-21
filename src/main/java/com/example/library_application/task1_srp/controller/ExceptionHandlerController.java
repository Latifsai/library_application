package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.errors.CoreError;
import com.example.library_application.task1_srp.errors.CoreResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleException(ConstraintViolationException e) {
        List<CoreError> errors = e.getConstraintViolations().stream()
                .map(ex -> ex.getPropertyPath() + ex.getMessage())
                .map(s -> new CoreError(s))
                .toList();
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
