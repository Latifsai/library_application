package com.example.library_application.task1_srp.service.book.serviceImp;


import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.entity.Book;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.book.AddBookService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class AddBookServiceImp implements AddBookService {

    private final BookRepository repository;
    private final Convertor convertor;
    @Override
    public BookResponse execute(AddBookRequest request) {
        //get book
        Book book = convertor.convertRequestToBook(request);
        //save book
        repository.save(book);
        //get response
        // return response
        return convertor.convertBookToResponse(book);
    }
}
