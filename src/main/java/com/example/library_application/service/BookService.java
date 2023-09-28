package com.example.library_application.service;

import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.GetBooksBelongsAuthorResponse;
import com.example.library_application.dto.book.UpdateBookRequest;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookResponse addBook(AddBookRequest request);
    BookResponse findBookByID(UUID id);
    BookResponse updateBook(UpdateBookRequest request);
    BookResponse findByTitle(String title);
    List<BookResponse> getAllBooks();
    GetBooksBelongsAuthorResponse getAllBooksBelongsAuthor(String name, String surname);
}
