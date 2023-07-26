package com.example.library_application.task1_srp.dto.reader;

import lombok.Value;

@Value
public class FindReaderRequest {
    String code;
    Integer id;
}
