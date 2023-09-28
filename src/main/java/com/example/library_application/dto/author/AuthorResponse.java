package com.example.library_application.dto.author;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class AuthorResponse {
    UUID id;
    String name;
    String surname;
    Integer yearOfBorn;
    String country;
    String language;
}
