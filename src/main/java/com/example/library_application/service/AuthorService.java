package com.example.library_application.service;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.author.CreateAuthorRequest;
import com.example.library_application.dto.author.SearchByAuthorNameRequest;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponse addAuthor(CreateAuthorRequest request);
    void deleteAuthor(UUID id);
    AuthorResponse searchByID(UUID id);
    List<AuthorResponse> findAllAuthors();
    AuthorResponse searchByAuthorName(SearchByAuthorNameRequest request);
}
