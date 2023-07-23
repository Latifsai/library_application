package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.ReaderRequest;
import com.example.library_application.task1_srp.dto.reader.ReaderResponse;
import org.springframework.stereotype.Service;

@Service
public interface DeleteReaderService {
    ReaderResponse execute(ReaderRequest request);
}
