package com.example.library_application.dto.readerBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLibraryControllerRequest {
    private String personalCode;
}
