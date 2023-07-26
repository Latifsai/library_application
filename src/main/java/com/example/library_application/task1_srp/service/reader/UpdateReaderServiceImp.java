package com.example.library_application.task1_srp.service.reader;

import com.example.library_application.task1_srp.dto.reader.UpdateReaderRequest;
import com.example.library_application.task1_srp.dto.reader.UpdateReaderResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
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
public class UpdateReaderServiceImp implements AllService<UpdateReaderResponse, UpdateReaderRequest> {
    private final ReaderRepository repository;
    private final Convertor convertor;
    private final Validator validator;

    @Override
    public UpdateReaderResponse execute(UpdateReaderRequest request) {
        validator.validationRightsExecution(request.getPersonalAdminCode());

        var reader = repository.findById(request.getId());

        if (reader.isPresent()) {
            var changedReader = convertor.updateReader(reader.get(), request);
            repository.save(changedReader);
            return new UpdateReaderResponse(changedReader.getId(), changedReader.getForename(), changedReader.getSurname());
        }

        throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);
    }
}
