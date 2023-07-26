package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTORequest;
import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTOResponse;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.service.util.Convertor;
import com.example.library_application.task1_srp.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@AllArgsConstructor
public class RegisterReaderServiceImp implements AllService<RegisterReaderDTOResponse, RegisterReaderDTORequest> {

    private final ReaderRepository repository;
    private final Convertor convertor;
    private final Validator validator;
    @Override
    public RegisterReaderDTOResponse execute(RegisterReaderDTORequest request) {
        validator.validationRightsExecution(request.getAdminCode());

        var reader = convertor.convertRequestToReader(request);
        repository.save(reader);
        return convertor.convertReaderToResponse(reader);
    }
}
