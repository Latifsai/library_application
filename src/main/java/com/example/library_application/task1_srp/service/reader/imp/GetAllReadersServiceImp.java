package com.example.library_application.task1_srp.service.reader.imp;

import com.example.library_application.task1_srp.dto.reader.GetAllReaderResponse;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.reader.GetAllReaderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@AllArgsConstructor
public class GetAllReadersServiceImp implements GetAllReaderService {
    private final ReaderRepository readerRepository;

    @Override
    public GetAllReaderResponse execute() {
        return new GetAllReaderResponse(readerRepository.findAll());
    }
}
