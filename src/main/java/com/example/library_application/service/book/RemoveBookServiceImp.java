package com.example.library_application.service.book;

import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.BookRepository;
import com.example.library_application.dto.book.BookDTORequest;
import com.example.library_application.dto.book.DeleteBookResponse;
import com.example.library_application.errors.Message;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RemoveBookServiceImp implements AllService<DeleteBookResponse, BookDTORequest> {

    private final BookRepository repository;
    private final Validator validator;

    @Override
    public DeleteBookResponse execute(BookDTORequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        var bookToDelete = repository.findByTitleOrAuthor(request.getTitle(), request.getAuthor());

        if (bookToDelete.isPresent()) {
            var response = new DeleteBookResponse(bookToDelete.get().getId(), bookToDelete.get().getTitle());
            repository.delete(bookToDelete.get());
            return response;
        }

        throw new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE);
    }
}
