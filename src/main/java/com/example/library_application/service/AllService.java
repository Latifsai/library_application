package com.example.library_application.service;

public interface AllService<R,I> {
    R execute(I i);
}
