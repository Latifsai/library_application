package com.example.library_application.task1_srp.service.util;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.UpdateBookDTORequest;
import com.example.library_application.task1_srp.dto.book.UpdateBookDTOResponse;
import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTORequest;
import com.example.library_application.task1_srp.dto.reader.RegisterReaderDTOResponse;
import com.example.library_application.task1_srp.dto.reader.UpdateReaderRequest;
import com.example.library_application.task1_srp.dto.reader.UpdateReaderResponse;
import com.example.library_application.task1_srp.entity.Book;
import com.example.library_application.task1_srp.entity.Reader;
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

    public BookResponse convertBookToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        return response;
    }

    public Book updateBook(Book book, UpdateBookDTORequest request) {
        book.setDescription(request.getDescription());
        book.setPageAmount(request.getPageAmount());
        return book;
    }

    public UpdateBookDTOResponse convertBookToUpdateResponse(Book book) {
        UpdateBookDTOResponse response = new UpdateBookDTOResponse();
        response.setPageAmount(book.getPageAmount());
        response.setDescription(book.getDescription());
        return response;
    }

    public Reader convertRequestToReader(RegisterReaderDTORequest request) {
        Reader reader = new Reader();
        reader.setForename(request.getForename());
        reader.setSurname(request.getSurname());
        reader.setPersonalCode(createPersonalCode(request));
        return reader;
    }
    public RegisterReaderDTOResponse convertReaderToResponse(Reader reader) {
        var response = new RegisterReaderDTOResponse();
        response.setForename(reader.getForename());
        response.setSurname(reader.getSurname());
        response.setId(reader.getId());
        return response;
    }

    public Reader updateReader(Reader reader, UpdateReaderRequest request) {
      reader.setSurname(request.getSurname());
      reader.setForename(request.getForename());
      return reader;
    }


    private String createPersonalCode(RegisterReaderDTORequest request) {
        return request.getForename().hashCode() + request.getSurname().hashCode() + "";
    }
}
