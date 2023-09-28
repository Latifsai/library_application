package com.example.library_application.generator;

import com.example.library_application.dto.author.AuthorResponse;

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

}
