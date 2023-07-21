package com.example.library_application.task1_srp.service.util;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.AddBookResponse;
import com.example.library_application.task1_srp.entity.Book;
import org.springframework.stereotype.Component;
@Component
public class Convertor {

    public Book convertRequestToBook(AddBookRequest request) {
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPageAmount(request.getPageAmount());
        return book;
    }

    public AddBookResponse convertBookToResponse(Book book) {
        AddBookResponse response = new AddBookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        return response;
    }
}
