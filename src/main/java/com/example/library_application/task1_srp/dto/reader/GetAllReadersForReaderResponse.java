package com.example.library_application.task1_srp.dto.reader;

import lombok.Value;

import java.util.List;

@Value
public class GetAllReadersForReaderResponse {

    List<ResponseForUser> list;
}
