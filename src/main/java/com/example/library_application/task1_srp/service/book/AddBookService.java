package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.BookResponse;
import org.springframework.stereotype.Service;

@Service
public interface AddBookService {
    BookResponse execute(AddBookRequest request);
}
