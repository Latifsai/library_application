package com.example.library_application.task1_srp.service.book.serviceImp;

import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.BookDTORequest;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.book.FindBookService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Transactional
public class FindBookServiceImp implements FindBookService {
    private final BookRepository repository;
    private final Convertor convertor;
    @Override
    public BookResponse findBookByTitleOrAuthor(BookDTORequest request) {
        //find book from request
        var bookToFind = repository.findByTitleOrAuthor(request.getTitle(), request.getAuthor())
                .orElseThrow(() -> new NotfoundException(Message.BOOK_NOT_FOUND_MESSAGE));
        //get response from founded book
        return convertor.convertBookToResponse(bookToFind);
    }

}
