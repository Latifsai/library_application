package com.example.library_application.dto.readerBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeBookDTOResponse {
    private String bookTitle;
    private String readerName;
    private String readerSurname;
    private LocalDateTime bookOutDate;
}
