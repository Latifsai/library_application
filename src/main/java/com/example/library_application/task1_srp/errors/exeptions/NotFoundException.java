package com.example.library_application.task1_srp.errors.exeptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
