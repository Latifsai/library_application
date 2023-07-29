package com.example.library_application.service.util;

import com.example.library_application.dto.admin.CreateAdminRequest;
import com.example.library_application.dto.admin.UpdateAdminRequest;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.UpdateBookDTORequest;
import com.example.library_application.dto.book.UpdateBookDTOResponse;
import com.example.library_application.dto.reader.RegisterReaderDTORequest;
import com.example.library_application.dto.reader.RegisterReaderDTOResponse;
import com.example.library_application.dto.reader.UpdateReaderRequest;
import com.example.library_application.entity.Admin;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.LibraryController;
import com.example.library_application.entity.Reader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
        if (request.getDescription() != null) book.setDescription(request.getDescription());
        if (request.getPageAmount() != null) book.setPageAmount(request.getPageAmount());
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
        if (request.getSurname() != null) reader.setSurname(request.getSurname());
        if (request.getForename() != null) reader.setForename(request.getForename());
        return reader;
    }

    public LibraryController convertByTakingBookRequestsToController(Book book, Reader reader) {
        LibraryController libraryController = new LibraryController();
        libraryController.setBook(book);
        libraryController.setReader(reader);
        libraryController.setBookOutDate(LocalDateTime.now());
        return libraryController;
    }

    public LibraryController convertByReturningBookRequestsToController(Book book, Reader reader) {
        LibraryController libraryController = new LibraryController();
        libraryController.setBook(book);
        libraryController.setReader(reader);
        libraryController.setBookReturnDate(LocalDateTime.now());
        return libraryController;
    }

    private String createPersonalCode(RegisterReaderDTORequest request) {
        return request.getForename().hashCode() + request.getSurname().hashCode() + "";
    }

    public Admin convertRequestToAdmin(CreateAdminRequest request) {
        Admin admin = new Admin();
        admin.setName(request.getName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setPersonalCodeForAdmin(createCodeForAdmins(request));
        return admin;
    }

    private String createCodeForAdmins(CreateAdminRequest request) {
        return request.getName().hashCode() + request.getEmail().hashCode() + "adm";
    }

    public Admin updateAdmin(Admin admin, UpdateAdminRequest request) {
        if (admin.getName() != null) admin.setName(request.getName());
        if (admin.getEmail() != null) admin.setEmail(request.getEmail());
        if (admin.getPassword() != null) admin.setPassword(request.getPassword());
        return admin;
    }

}
