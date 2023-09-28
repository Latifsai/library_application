package com.example.library_application.dto.book;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GetBooksBelongsAuthorResponse {
    String authorName;
    Integer yearOfBorn;
    String country;
    String language;
    List<BookResponseForList> listOfBooks;
}
