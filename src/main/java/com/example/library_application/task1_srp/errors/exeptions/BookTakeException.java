package com.example.library_application.task1_srp.errors.exeptions;

public class BookTakeException extends RuntimeException {
    public BookTakeException(String message) {
        super(message);
    }
}
