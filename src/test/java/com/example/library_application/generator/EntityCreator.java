package com.example.library_application.generator;

import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.BookStatus;

import java.util.Collections;
import java.util.UUID;

public class EntityCreator {

    public static Author getAuthor() {
        return new Author(
                UUID.randomUUID(),
                "Lev",
                "Tolstoy",
                1969,
                "Russia",
                "Russian",
                Collections.emptyList()
                );
    }

    public static Book getBook() {
        return new Book(
                UUID.randomUUID(),
                "Fight of Ice and Fire",
                "46B7BH5",
                getAuthor(),
                1000,
                "The roman about people",
                1970,
                BookStatus.AVAILABLE,
                "Bestseller"
        );
    }

}
