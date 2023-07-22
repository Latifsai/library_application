package com.example.library_application.task1_srp.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddAndFindBookResponse {
    private Integer id;
    private String title;
    private String author;
}
