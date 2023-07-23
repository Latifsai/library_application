package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTORequest;
import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface RegisterReaderService {
    RegisterReaderDTOResponse execute(RegisterReaderDTORequest request);
}
