package com.example.library_application.dto.book;

import com.example.library_application.entity.enums.BookStatus;
import lombok.Value;

import java.util.UUID;

@Value
public class UpdateBookRequest {
    UUID id;
    String title;
    Integer pageAmount;
    String description;
    Integer yearOfRelease;
    BookStatus status;
    String frameOfBook;
}
