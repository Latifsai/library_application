package com.example.library_application.validation.exeptions;

public class BookTakeException extends RuntimeException {
    public BookTakeException(String message) {
        super(message);
    }
}
