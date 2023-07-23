package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.BookDTORequest;
import org.springframework.stereotype.Service;

@Service
public interface FindBookService {
    BookResponse findBookByTitleOrAuthor(BookDTORequest request);

}
