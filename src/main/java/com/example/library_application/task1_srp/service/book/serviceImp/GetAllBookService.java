package com.example.library_application.task1_srp.service.book.serviceImp;

import com.example.library_application.task1_srp.dto.book.GetAllBooksResponse;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.book.GetAllBooksService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
public class GetAllBookService implements GetAllBooksService {

    private final BookRepository repository;
    @Override
    public GetAllBooksResponse execute() {
        return new GetAllBooksResponse(repository.findAll());
    }
}
