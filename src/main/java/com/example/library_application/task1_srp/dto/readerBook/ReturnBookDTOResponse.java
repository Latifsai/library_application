package com.example.library_application.task1_srp.dto.readerBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookDTOResponse {
    private String bookTitle;
    private String readerName;
    private String readerSurname;
    private LocalDateTime bookReturnDate;
}
