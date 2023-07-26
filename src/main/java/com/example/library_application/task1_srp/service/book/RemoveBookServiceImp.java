package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.BookDTORequest;
import com.example.library_application.task1_srp.dto.book.DeleteBookResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.validation.Validator;
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
