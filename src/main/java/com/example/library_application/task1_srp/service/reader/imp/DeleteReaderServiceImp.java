package com.example.library_application.task1_srp.service.reader.imp;

import com.example.library_application.task1_srp.dto.reader.ReaderRequest;
import com.example.library_application.task1_srp.dto.reader.ReaderResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.reader.DeleteReaderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DeleteReaderServiceImp implements DeleteReaderService {
    private final ReaderRepository repository;

    @Override
    public ReaderResponse execute(ReaderRequest request) {
        var reader = repository.findByPersonalCode(request.getPersonalCode());

        if (reader.isPresent()) {
            var response = new ReaderResponse(reader.get().getForename(), reader.get().getSurname());
            repository.delete(reader.get());
            return response;
        }

        throw new NotfoundException(Message.READER_NOT_FOUND_MESSAGE);

    }
}
