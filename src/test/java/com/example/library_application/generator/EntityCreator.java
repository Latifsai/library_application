package com.example.library_application.generator;

import com.example.library_application.entity.Author;

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

}
