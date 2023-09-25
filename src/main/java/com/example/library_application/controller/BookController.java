package com.example.library_application.controller;

import com.example.library_application.dto.book.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final AllService<BookResponse, AddBookRequest> addBookService;
    private final GetService<GetAllBooksResponse> getAllBooksService;
    private final AllService<BookResponse, BookDTORequest> findBookService;
    private final AllService<BookResponse, BookDTORequest> removeBookService;
    private final AllService<UpdateBookDTOResponse, UpdateBookDTORequest> updateService;

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody AddBookRequest request) {
        BookResponse response = addBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        GetAllBooksResponse response = getAllBooksService.execute();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/book")
    public ResponseEntity<BookResponse> findBook(@RequestBody BookDTORequest request) {
        BookResponse response = findBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping
    public ResponseEntity<BookResponse> deleteBook(@RequestBody BookDTORequest request) {
        BookResponse response = removeBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateBookDTOResponse> updateBook(@RequestBody UpdateBookDTORequest request) {
        UpdateBookDTOResponse response = updateService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
    }

}
