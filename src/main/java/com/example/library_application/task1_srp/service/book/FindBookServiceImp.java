package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.BookDTORequest;
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
@RequiredArgsConstructor
@Transactional
public class FindBookServiceImp implements AllService<BookResponse,BookDTORequest> {
    private final BookRepository repository;
    private final Convertor convertor;
    private final Validator validator;
    @Override
    public BookResponse execute(BookDTORequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        //find book from request
        var bookToFind = repository.findByTitleOrAuthor(request.getTitle(), request.getAuthor())
                .orElseThrow(() -> new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE));
        //get response from founded book
        return convertor.convertBookToResponse(bookToFind);
    }

}
