package com.example.library_application.dto.author;

import lombok.Value;

@Value
public class SearchByAuthorNameRequest {
    String name;
    String surname;
}
