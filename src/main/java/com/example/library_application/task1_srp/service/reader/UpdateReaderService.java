package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.UpdateReaderRequest;
import com.example.library_application.task1_srp.dto.reader.UpdateReaderResponse;

public interface UpdateReaderService {

    UpdateReaderResponse execute(UpdateReaderRequest request);
}
