package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.GetAllReaderResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetAllReaderService {
    GetAllReaderResponse execute();
}
