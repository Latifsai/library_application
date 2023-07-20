package com.example.library_application.task1_srp.service.book;


import com.example.library_application.task1_srp.repositiry.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AddBookService {

    private final BookRepository repository;


//    public AddBookResponse execute(AddBookRequest request) {
//        AddBookRequestValidator validator = new AddBookRequestValidator();
//        List<CoreError> errors = validator.validate(request);
//
//        if (!errors.isEmpty()) {
//            return new AddBookResponse(errors);
//        }
//
//        Book book = new Book(request.getTitle(), request.getAuthor());
//        AddBookResponse response = new AddBookResponse(book);
//        repository.save(response.getBook());
//
//        return response;
//
//
//    }
}
