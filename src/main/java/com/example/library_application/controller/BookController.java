package com.example.library_application.controller;

import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.GetBooksBelongsAuthorResponse;
import com.example.library_application.dto.book.UpdateBookRequest;
import com.example.library_application.service.implementation.BookServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("library/book")
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImp bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse addBook(@RequestBody @Valid AddBookRequest request) {
        return bookService.addBook(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookResponse findBookByID(@PathVariable("id") UUID id) {
        return bookService.findBookByID(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse update(@RequestBody @Valid UpdateBookRequest request) {
        return bookService.updateBook(request);
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookResponse findByTitle(@PathVariable("title") String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/all_books_in_library")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books_of_author")
    @ResponseStatus(HttpStatus.FOUND)
    public GetBooksBelongsAuthorResponse getAllBooksBelongsAuthor(@RequestBody @Valid SearchByAuthorNameRequest request) {
        return bookService.getAllBooksBelongsAuthor(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(String title) {
        bookService.deleteBook(title);
    }
}