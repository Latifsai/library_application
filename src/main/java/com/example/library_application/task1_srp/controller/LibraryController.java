package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.dto.readerBook.*;
import com.example.library_application.task1_srp.service.AllService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class LibraryController {
    private final AllService<TakeBookDTOResponse, TakeAndReturnBookDTORequest> takeBookService;
    private final AllService<ReturnBookDTOResponse, TakeAndReturnBookDTORequest> returnBookService;
    private final AllService<SearchLibraryControllerResponse, DeleteAndSearchControllerRequest> searchLibraryControllerService;
    private final AllService<GetAllLibraryControllersResponse, GetLibraryControllerRequest> getAllLibraryControllersService;
    private final AllService<DeleteControllerResponse, DeleteAndSearchControllerRequest> delete;
    @PostMapping
    public ResponseEntity<TakeBookDTOResponse> takeBook(@RequestBody TakeAndReturnBookDTORequest request) {
        TakeBookDTOResponse response = takeBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReturnBookDTOResponse> returnBook(@RequestBody TakeAndReturnBookDTORequest request) {
        ReturnBookDTOResponse response = returnBookService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/controller")
    public ResponseEntity<SearchLibraryControllerResponse> findByIdController(@RequestBody DeleteAndSearchControllerRequest request) {
        SearchLibraryControllerResponse response = searchLibraryControllerService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetAllLibraryControllersResponse> getAllControllers(@RequestBody GetLibraryControllerRequest request) {
        GetAllLibraryControllersResponse response = getAllLibraryControllersService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<DeleteControllerResponse> DeleteBook(@RequestBody DeleteAndSearchControllerRequest request) {
        DeleteControllerResponse response = delete.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
