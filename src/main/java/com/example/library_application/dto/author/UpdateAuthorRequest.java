package com.example.library_application.dto.author;

import lombok.Value;

import java.util.UUID;

@Value
public class UpdateAuthorRequest {
    UUID id;
    String name;
    String surname;
    Integer yearOfBorn;
    String country;
    String language;
}
