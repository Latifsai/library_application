package com.example.library_application.task1_srp.service.reader.imp;

import com.example.library_application.task1_srp.dto.reader.UpdateReaderRequest;
import com.example.library_application.task1_srp.dto.reader.UpdateReaderResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.reader.UpdateReaderService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UpdateReaderServiceImp implements UpdateReaderService {
    private final ReaderRepository repository;
    private final Convertor convertor;

    @Override
    public UpdateReaderResponse execute(UpdateReaderRequest request) {
        var reader = repository.findByPersonalCode(request.getPersonalCode());

        if (reader.isPresent()) {
            var changedReader = convertor.updateReader(reader.get(), request);
            repository.save(changedReader);
            return new UpdateReaderResponse(changedReader.getId(), changedReader.getForename(), changedReader.getSurname());
        }

        throw new NotfoundException(Message.READER_NOT_FOUND_MESSAGE);
    }
}
