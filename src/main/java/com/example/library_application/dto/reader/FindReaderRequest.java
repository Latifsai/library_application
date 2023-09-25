package com.example.library_application.dto.reader;

import lombok.Value;

@Value
public class FindReaderRequest {
    Integer id;
    String code;

}
