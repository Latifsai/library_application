package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.dto.book.AddBookRequest;
import com.example.library_application.task1_srp.dto.book.AddBookResponse;
import com.example.library_application.task1_srp.dto.book.GetAllBooksResponse;
import com.example.library_application.task1_srp.service.book.AddBookService;
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

    @PostMapping
    public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest request) {
        AddBookResponse response = addBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        GetAllBooksResponse response = getAllBooksService.execute();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
