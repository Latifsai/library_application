package com.example.library_application.dto.reader;

import lombok.Value;

import java.util.List;

@Value
public class GetAllReadersForReaderResponse {

    List<ResponseForUser> list;
}
