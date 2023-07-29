package com.example.library_application.controller;

import com.example.library_application.dto.admin.*;
import com.example.library_application.service.AllService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AllService<CreateAdminResponse, CreateAdminRequest> createService;
    private final AllService<DeleteAdminResponse, DeleteAdminRequest> deleteService;
    private final AllService<GetAllAdminsResponse, GetAllAdminsRequest> getAdmService;
    private final AllService<SearchAdminResponse, SearchAdminRequest> searchService;
    private final AllService<UpdateAdminResponse, UpdateAdminRequest> updateService;


    @PostMapping
    public ResponseEntity<CreateAdminResponse> create(@RequestBody CreateAdminRequest request) {
        var response = createService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<DeleteAdminResponse> delete(@RequestBody DeleteAdminRequest request) {
        var response = deleteService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetAllAdminsResponse> get(@RequestBody GetAllAdminsRequest request) {
        var response = getAdmService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<UpdateAdminResponse> update(@RequestBody UpdateAdminRequest request) {
        var response = updateService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/search")
    public ResponseEntity<SearchAdminResponse> search(@RequestBody SearchAdminRequest request) {
        var response = searchService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

}
