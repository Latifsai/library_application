package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.AddAndFindBookResponse;
import com.example.library_application.task1_srp.dto.book.FindBookDTORequest;
import org.springframework.stereotype.Service;

@Service
public interface FindBookService {
    AddAndFindBookResponse findBookByTitleOrAuthor(FindBookDTORequest request);

}
