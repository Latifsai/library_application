package com.example.library_application.task1_srp.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBookRequest {
    private String title;
    private String author;
    private Integer pageAmount;
    private String description;
}
