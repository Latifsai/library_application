package com.example.library_application.task1_srp.service.reader.imp;

import com.example.library_application.task1_srp.dto.reader.ReaderResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.reader.FindReaderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class FindReaderServiceImp implements FindReaderService {

    private final ReaderRepository repository;

    @Override
    public ReaderResponse execute(Integer id) {
        var reader = repository.findById(id);

        if (reader.isPresent()) {
            return new ReaderResponse(reader.get().getForename(), reader.get().getSurname());
        }

        throw new NotfoundException(Message.READER_NOT_FOUND_MESSAGE);
    }
}
