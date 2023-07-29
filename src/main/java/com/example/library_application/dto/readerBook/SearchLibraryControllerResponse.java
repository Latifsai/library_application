package com.example.library_application.dto.readerBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLibraryControllerResponse {
    private Integer id;
    private LocalDateTime bookOutDate;
    private LocalDateTime bookReturnDate;
    private Integer book_id;
    private Integer reader_id;
}
