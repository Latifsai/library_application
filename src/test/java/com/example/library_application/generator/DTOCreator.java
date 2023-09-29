package com.example.library_application.generator;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.GetBooksBelongsAuthorResponse;
import com.example.library_application.entity.enums.BookStatus;

import java.util.ArrayList;
import java.util.UUID;

public class DTOCreator {

    public static AuthorResponse getAuthorResponse() {
        return AuthorResponse.builder()
                .id(UUID.randomUUID())
                .name("Lev")
                .surname("Tolstoy")
                .yearOfBorn(1969)
                .country("Russia")
                .language("Russian")
                .build();
    }

    public static BookResponse getBookResponse() {
        return BookResponse.builder()
                .id(UUID.randomUUID())
                .title("Fight of Ice and Fire")
                .specialNumberOfBook("46B7BH5")
                .pageAmount(1000)
                .description("The roman about people")
                .yearOfRelease(1970)
                .status(BookStatus.AVAILABLE)
                .frameOfBook("Bestseller")
                .authorName("John Orel")
                .build();
    }

    public static GetBooksBelongsAuthorResponse getBooksBelongsAuthorResponse() {
        return GetBooksBelongsAuthorResponse.builder()
                .authorName("Lev Tolstoy")
                .yearOfBorn(1969)
                .country("Russia")
                .language("rus")
                .listOfBooks(new ArrayList<>())
                .build();
    }
}
