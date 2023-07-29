package com.example.library_application.dto.book;

import lombok.Value;

@Value
public class UpdateBookDTORequest {
    String personalCode;
    String title;
    Integer pageAmount;
    String description;
}
