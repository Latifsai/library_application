package com.example.library_application.service.reader;

import com.example.library_application.dto.reader.GetAllReaderResponseForAdmin;
import com.example.library_application.dto.reader.GetAllReadersForReaderResponse;
import com.example.library_application.dto.reader.ReaderRequest;
import com.example.library_application.dto.reader.ResponseForUser;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.RightsException;
import com.example.library_application.repositiry.ReaderRepository;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class GetAllReadersServiceImp implements AllService<GetAllReaderResponseForAdmin, ReaderRequest> {
    private final ReaderRepository readerRepository;
    private final Validator validator;


    public GetAllReadersForReaderResponse executeForReader(ReaderRequest request) {

        if (!request.getPersonalCode().contains("adm")) {
            var list = readerRepository.findAll();
            return new GetAllReadersForReaderResponse(list.stream()
                    .map(reader -> new ResponseForUser(reader.getForename(), reader.getSurname()))
                    .collect(Collectors.toList()));
        }

        throw new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE);
    }

    @Override
    public GetAllReaderResponseForAdmin execute(ReaderRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        return new GetAllReaderResponseForAdmin(readerRepository.findAll());
    }
}
