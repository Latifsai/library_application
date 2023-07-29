package com.example.library_application.service.book;

import com.example.library_application.repositiry.BookRepository;
import com.example.library_application.service.util.Convertor;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.entity.Book;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AddBookServiceImp implements AllService<BookResponse, AddBookRequest> {

    private final BookRepository repository;
    private final Convertor convertor;
    private final Validator validator;
    @Override
    public BookResponse execute(AddBookRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        //get book
        Book book = convertor.convertRequestToBook(request);
        //save book
        repository.save(book);
        //get response
        // return response
        return convertor.convertBookToResponse(book);
    }
}
