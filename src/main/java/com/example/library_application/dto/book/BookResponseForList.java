package com.example.library_application.dto.book;

import com.example.library_application.entity.enums.BookStatus;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class BookResponseForList {
    UUID id;
    String title;
    Integer pageAmount;
    String description;
    Integer yearOfRelease;
    BookStatus status;
    String frameOfBook;
}
