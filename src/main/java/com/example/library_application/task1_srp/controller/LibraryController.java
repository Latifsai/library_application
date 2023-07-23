package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.dto.book.*;
import com.example.library_application.task1_srp.service.book.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class LibraryController {
    private final AddBookService addBookService;
    private final GetAllBooksService getAllBooksService;
    private final FindBookService findBookService;
    private final RemoveBookService removeBookService;
    private final UpdateService updateService;

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
        BookResponse response = findBookService.findBookByTitleOrAuthor(request);
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
