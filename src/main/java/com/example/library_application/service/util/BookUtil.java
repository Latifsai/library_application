package com.example.library_application.service.util;

import com.example.library_application.dto.book.*;
import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.BookStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUtil {
    public Book createBook(AddBookRequest request, Author author) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setSpecialNumberOfBook(Generator.getInstance().generateNumber(request.getLengthOfNumber()));
        book.setAuthor(author);
        book.setPageAmount(request.getPageAmount());
        book.setDescription(request.getDescription());
        book.setYearOfRelease(request.getYearOfRelease());
        book.setStatus(BookStatus.AVAILABLE);
        book.setFrameOfBook(request.getFrameOfBook());
        return book;
    }

    public GetBooksBelongsAuthorResponse getResponseBelongAuthor(Author author, List<Book> books) {
        return GetBooksBelongsAuthorResponse.builder()
                .authorName(author.getName() + " " + author.getSurname())
                .yearOfBorn(author.getYearOfBorn())
                .country(author.getCountry())
                .language(author.getLanguage())
                .listOfBooks(books.stream()
                        .map(this::convertToBookResponseForList)
                        .toList())
                .build();
    }

    private BookResponseForList convertToBookResponseForList(Book book) {
        return BookResponseForList.builder()
                .id(book.getId())
                .title(book.getTitle())
                .pageAmount(book.getPageAmount())
                .description(book.getDescription())
                .yearOfRelease(book.getYearOfRelease())
                .status(book.getStatus())
                .frameOfBook(book.getFrameOfBook())
                .build();
    }

    public BookResponse getResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .specialNumberOfBook(book.getSpecialNumberOfBook())
                .pageAmount(book.getPageAmount())
                .description(book.getDescription())
                .yearOfRelease(book.getYearOfRelease())
                .status(book.getStatus())
                .frameOfBook(book.getFrameOfBook())
                .authorName(book.getAuthor().getName() + " " + book.getAuthor().getSurname())
                .build();
    }

    public Book update(UpdateBookRequest request, Book book) {
        if(checkStringParams(request.getTitle())) book.setTitle(request.getTitle());
        if(checkIntegerParams(request.getPageAmount())) book.setPageAmount(request.getPageAmount());
        if (checkStringParams(request.getDescription())) book.setDescription(request.getDescription());
        if (checkIntegerParams(request.getYearOfRelease())) book.setYearOfRelease(request.getYearOfRelease());
        if (request.getStatus() != null) book.setStatus(request.getStatus());
        if (checkStringParams(request.getFrameOfBook())) book.setFrameOfBook(request.getFrameOfBook());
        return book;
    }

    private boolean checkIntegerParams(Integer criteria) {
        return criteria != null && criteria != 0;
    }
    private boolean checkStringParams(String criteria) {
        return !criteria.trim().isEmpty() && criteria != null;
    }
}
