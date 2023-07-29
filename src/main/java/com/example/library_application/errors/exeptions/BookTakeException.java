package com.example.library_application.errors.exeptions;

public class BookTakeException extends RuntimeException {
    public BookTakeException(String message) {
        super(message);
    }
}
