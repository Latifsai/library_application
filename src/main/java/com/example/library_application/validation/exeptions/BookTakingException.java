package com.example.library_application.validation.exeptions;

public class BookTakingException extends RuntimeException {
    public BookTakingException(String message) {
        super(message);
    }
}
