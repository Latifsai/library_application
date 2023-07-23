package com.example.library_application.task1_srp.service.reader.imp;

import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTORequest;
import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTOResponse;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.reader.RegisterReaderService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@AllArgsConstructor
public class RegisterReaderServiceImp implements RegisterReaderService {

    private final ReaderRepository repository;
    private final Convertor convertor;
    @Override
    public RegisterReaderDTOResponse execute(RegisterReaderDTORequest request) {
        var reader = convertor.convertRequestToReader(request);
        repository.save(reader);
        return convertor.convertReaderToResponse(reader);
    }
}
