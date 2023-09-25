package com.example.library_application.service.book;

import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.BookRepository;
import com.example.library_application.service.util.Convertor;
import com.example.library_application.dto.book.UpdateBookDTORequest;
import com.example.library_application.dto.book.UpdateBookDTOResponse;
import com.example.library_application.errors.Message;
import com.example.library_application.validation.Validator;
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

        if (book.isPresent()) {
            var updatedBook = convertor.updateBook(book.get(), request);
            repository.save(updatedBook);
            return convertor.convertBookToUpdateResponse(updatedBook);
        }

        throw new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE);
    }
}
