package com.example.library_application.controller;

import com.example.library_application.validation.exeptions.*;
import com.example.library_application.validation.errors.CoreError;
import com.example.library_application.validation.errors.CoreResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleException(ConstraintViolationException e) {
        List<CoreError> errors = e.getConstraintViolations().stream()
                .map(ex -> ex.getPropertyPath() + ex.getMessage())
                .map(CoreError::new)
                .toList();
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(NotFoundException e) {
        List<CoreError> errors = List.of(new CoreError(e.getMessage()));
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookTakingException.class)
    public ResponseEntity<?> handleException(BookTakingException e) {
        List<CoreError> errors = List.of(new CoreError(e.getMessage()));
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RightsException.class)
    public ResponseEntity<?> handleException(RightsException e) {
        List<CoreError> errors = List.of(new CoreError(e.getMessage()));
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleException(com.example.library_application.validation.exeptions.ValidationException e) {
        List<CoreError> errors = List.of(new CoreError(e.getMessage()));
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> handleException(AlreadyExistException e) {
        List<CoreError> errors = List.of(new CoreError(e.getMessage()));
        CoreResponse response = new CoreResponse(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
