package com.example.library_application.controller;

import com.example.library_application.dto.reader.*;
import com.example.library_application.service.AllService;
import com.example.library_application.service.reader.FindReaderServiceImp;
import com.example.library_application.service.reader.GetAllReadersServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final AllService<RegisterReaderDTOResponse, RegisterReaderDTORequest> registerService;
    private final GetAllReadersServiceImp getAllReaderService;
    private final FindReaderServiceImp findReaderService;
    private final AllService<ReaderResponse, ReaderRequest> deleteReaderService;
    private final AllService<UpdateReaderResponse, UpdateReaderRequest> updateReaderService;

    @PostMapping
    public ResponseEntity<RegisterReaderDTOResponse> registerReader(@RequestBody RegisterReaderDTORequest request) {
        RegisterReaderDTOResponse response = registerService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> getAllReaders(@RequestBody ReaderRequest request) {
        if (request.getPersonalCode().contains("adm")){
            var response = getAllReaderService.execute(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }   else {
            var response = getAllReaderService.executeForReader(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }

    }

    @GetMapping("/reader")
    public ResponseEntity<?> findReader(@RequestBody FindReaderRequest request) {
        if (request.getCode().contains("adm")) {
            var response = findReaderService.executeForAdmin(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            var response = findReaderService.execute(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }

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
