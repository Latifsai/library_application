package com.example.library_application.task1_srp.service.reader;


import com.example.library_application.task1_srp.dto.reader.ReaderResponse;

public interface FindReaderService {
    ReaderResponse execute(Integer id);
}
