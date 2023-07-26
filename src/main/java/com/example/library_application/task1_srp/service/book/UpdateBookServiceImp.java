package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.UpdateBookDTORequest;
import com.example.library_application.task1_srp.dto.book.UpdateBookDTOResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.service.util.Convertor;
import com.example.library_application.task1_srp.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateBookServiceImp implements AllService<UpdateBookDTOResponse, UpdateBookDTORequest> {
    private final BookRepository repository;
    private final Convertor convertor;
    private final Validator validator;
    @Override
    public UpdateBookDTOResponse execute(UpdateBookDTORequest request) {
        validator.validationRightsExecution(request.getPersonalCode());

        var book = repository.findByTitle(request.getTitle());
        if (book.isPresent()){
            var updatedBook = book.map(b -> convertor.updateBook(b,request)).get();
            repository.save(updatedBook);
            return convertor.convertBookToUpdateResponse(updatedBook);
        }

        throw new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE);
    }
}
