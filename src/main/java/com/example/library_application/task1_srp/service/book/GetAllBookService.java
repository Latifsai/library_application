package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.GetAllBooksResponse;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.GetService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class GetAllBookService implements GetService<GetAllBooksResponse> {

    private final BookRepository repository;
    @Override
    public GetAllBooksResponse execute() {
        return new GetAllBooksResponse(repository.findAll());
    }
}
