package com.example.library_application.task1_srp.controller;

import com.example.library_application.task1_srp.dto.reader.*;
import com.example.library_application.task1_srp.service.reader.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readers")
@AllArgsConstructor
public class ReaderController {
    private final RegisterReaderService registerService;
    private final GetAllReaderService getAllReaderService;
    private final FindReaderService findReaderService;
    private final DeleteReaderService deleteReaderService;
    private final UpdateReaderService updateReaderService;

    @PostMapping
    public ResponseEntity<RegisterReaderDTOResponse> registerReader(@RequestBody RegisterReaderDTORequest request) {
        RegisterReaderDTOResponse response = registerService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<GetAllReaderResponse> getAllReaders() {
        GetAllReaderResponse response = getAllReaderService.execute();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderResponse> findReader(@PathVariable Integer id) {
        ReaderResponse response = findReaderService.execute(id);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping
    public ResponseEntity<ReaderResponse> deleteReader(@RequestBody ReaderRequest request) {
        ReaderResponse response = deleteReaderService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateReaderResponse> putReader(@RequestBody UpdateReaderRequest request) {
        UpdateReaderResponse response = updateReaderService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
    }



}
