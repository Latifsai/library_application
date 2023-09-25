package com.example.library_application.service.reader;

import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.ReaderRepository;
import com.example.library_application.service.AllService;
import com.example.library_application.dto.reader.FindReaderRequest;
import com.example.library_application.dto.reader.ReaderResponse;
import com.example.library_application.dto.reader.ReaderResponseForAdmin;
import com.example.library_application.errors.Message;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FindReaderServiceImp implements AllService<ReaderResponse, FindReaderRequest> {

    private final ReaderRepository repository;
    private final Validator validator;

    public ReaderResponseForAdmin executeForAdmin(FindReaderRequest request) {
        validator.validationRightsExecution(request.getCode());
        var reader = repository.findById(request.getId());
        if (reader.isPresent()) {
            return new ReaderResponseForAdmin(reader.get().getId(), reader.get().getForename(),
                    reader.get().getSurname(), reader.get().getPersonalCode());
        }
        throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);
    }

    @Override
    public ReaderResponse execute(FindReaderRequest request) {
        var reader = repository.findById(request.getId());
        if (reader.isPresent()) {
            return new ReaderResponse(reader.get().getForename(), reader.get().getSurname());
        }
        throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);
    }
}
