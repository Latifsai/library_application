package com.example.library_application.task1_srp.service.book.serviceImp;

import com.example.library_application.task1_srp.dto.book.AddAndFindBookResponse;
import com.example.library_application.task1_srp.dto.book.FindBookDTORequest;
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
    public AddAndFindBookResponse findBookByTitleOrAuthor(FindBookDTORequest request) {
        //find book from request
        var bookToFind = repository.findByTitleOrAuthor(request.getTitle(), request.getAuthor())
                .orElseThrow(() -> new NotfoundException("Book was not found!"));
        //get response from founded book
        return convertor.convertBookToResponse(bookToFind);
    }

}
