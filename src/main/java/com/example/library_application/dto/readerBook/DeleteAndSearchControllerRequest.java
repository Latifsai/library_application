package com.example.library_application.dto.readerBook;

import lombok.Value;

@Value
public class DeleteAndSearchControllerRequest {
    String personalCode;
    Integer id;
}
