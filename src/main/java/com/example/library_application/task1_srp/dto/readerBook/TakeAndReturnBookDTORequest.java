package com.example.library_application.task1_srp.dto.readerBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeAndReturnBookDTORequest {
    private String personalCode;
    private String title;


}
