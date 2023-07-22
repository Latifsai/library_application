package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.AddAndFindBookResponse;
import com.example.library_application.task1_srp.dto.book.FindBookDTORequest;
import com.example.library_application.task1_srp.dto.book.GetAllBooksResponse;
import com.example.library_application.task1_srp.service.book.AddBookService;
import com.example.library_application.task1_srp.service.book.FindBookService;
import com.example.library_application.task1_srp.service.book.GetAllBooksService;
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

    @PostMapping
    public ResponseEntity<AddAndFindBookResponse> addBook(@RequestBody AddBookRequest request) {
        AddAndFindBookResponse response = addBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        GetAllBooksResponse response = getAllBooksService.execute();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/book")
    public ResponseEntity<AddAndFindBookResponse> findBook(@RequestBody FindBookDTORequest request) {
        AddAndFindBookResponse response = findBookService.findBookByTitleOrAuthor(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
