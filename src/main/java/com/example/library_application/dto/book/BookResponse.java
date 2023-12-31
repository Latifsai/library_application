package com.example.library_application.dto.book;

import com.example.library_application.entity.enums.BookStatus;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class BookResponse {
    UUID id;
    String title;
    String specialNumberOfBook;
    Integer pageAmount;
    String description;
    Integer yearOfRelease;
    BookStatus status;
    String frameOfBook;
    String authorName;
}
