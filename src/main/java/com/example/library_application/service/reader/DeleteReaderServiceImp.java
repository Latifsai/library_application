package com.example.library_application.service.reader;

import com.example.library_application.dto.reader.ReaderRequest;
import com.example.library_application.dto.reader.ReaderResponse;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.ReaderRepository;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DeleteReaderServiceImp implements AllService<ReaderResponse, ReaderRequest> {
    private final ReaderRepository repository;
    private final Validator validator;

    @Override
    public ReaderResponse execute(ReaderRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());

        var reader = repository.findById(request.getId());
        if (reader.isPresent()) {
            var response = new ReaderResponse(reader.get().getForename(), reader.get().getSurname());
            repository.delete(reader.get());
            return response;
        }

        throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);

    }
}
