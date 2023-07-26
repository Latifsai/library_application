package com.example.library_application.task1_srp.dto.readerBook;

import lombok.Value;

@Value
public class DeleteAndSearchControllerRequest {
    String personalCode;
    Integer id;
}
