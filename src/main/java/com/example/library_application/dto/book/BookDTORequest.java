package com.example.library_application.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTORequest {
    private String personalCode;
    private String title;
    private String author;
}
