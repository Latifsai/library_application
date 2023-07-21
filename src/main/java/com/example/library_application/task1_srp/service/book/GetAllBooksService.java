package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.GetAllBooksResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetAllBooksService {
     GetAllBooksResponse execute();
}
