package com.example.library_application.task1_srp.service.util;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.AddAndFindBookResponse;
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

    public AddAndFindBookResponse convertBookToResponse(Book book) {
        AddAndFindBookResponse response = new AddAndFindBookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        return response;
    }
}
