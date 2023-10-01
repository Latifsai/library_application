package com.example.library_application.service.implementation;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.author.CreateAuthorRequest;
import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.entity.Author;
import com.example.library_application.validation.exeptions.NotFoundException;
import com.example.library_application.repository.AuthorRepository;
import com.example.library_application.service.AuthorService;
import com.example.library_application.service.util.AuthorUtil;
import com.example.library_application.validation.ValidationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorServiceImp implements AuthorService {

    private final AuthorUtil util;
    private final AuthorRepository repository;

    @Override
    public AuthorResponse addAuthor(CreateAuthorRequest request) {
        Author author = util.createAuthorFromRequest(request);
        repository.save(author);
        return util.convertToResponse(author);
    }

    @Override
    public AuthorResponse searchByID(UUID id) {
        Author author = findAuthorByID(id);
        return util.convertToResponse(author);
    }

    @Override
    public void deleteAuthor(UUID id) {
        repository.delete(findAuthorByID(id));
    }

    @Override
    public List<AuthorResponse> findAllAuthors() {
        return repository.findAll().stream()
                .map(util::convertToResponse)
                .toList();
    }

    @Override
    public AuthorResponse searchByAuthorName(SearchByAuthorNameRequest request) {
        Author author = findByName(request.getName(), request.getSurname());
        return util.convertToResponse(author);
    }

    public Author findAuthorByID(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_AUTHOR_MESSAGE + id));
    }

    public Author findByName(String name, String surname) {
        return repository.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_AUTHOR_MESSAGE + name + " " + surname));
    }
}
