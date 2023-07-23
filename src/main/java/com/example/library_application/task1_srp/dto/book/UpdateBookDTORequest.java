package com.example.library_application.task1_srp.dto.book;

import lombok.Value;

@Value
public class UpdateBookDTORequest {
    private String title;
    private Integer pageAmount;
    private String description;
}
