package com.example.library_application.controller;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.author.CreateAuthorRequest;
import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.service.implementation.AuthorServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("library/author")
public class AuthorController {
    private final AuthorServiceImp authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse addAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        return authorService.addAuthor(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public AuthorResponse searchByID(@PathVariable("id") UUID id) {
        return authorService.searchByID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/all_authors")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AuthorResponse> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public AuthorResponse searchByAuthorName(@RequestBody @Valid SearchByAuthorNameRequest request) {
        return authorService.searchByAuthorName(request);
    }
}
