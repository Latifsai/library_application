package com.example.library_application.service.book;

import com.example.library_application.repositiry.BookRepository;
import com.example.library_application.dto.book.GetAllBooksResponse;
import com.example.library_application.service.GetService;
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
