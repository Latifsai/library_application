package com.example.library_application.service.author;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.author.CreateAuthorRequest;
import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.entity.Author;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.repositiry.AuthorRepository;
import com.example.library_application.service.util.AuthorUtil;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImpTest {

    @Mock
    private AuthorUtil util;
    @Mock
    private AuthorRepository repository;
    @InjectMocks
    private AuthorServiceImp serviceImp;

    private final Author author = EntityCreator.getAuthor();
    private final AuthorResponse response = DTOCreator.getAuthorResponse();
    private final UUID id = UUID.fromString("60d276ef-d9e1-4417-b292-e113fcf8ee33");

    @Test
    @DisplayName("Test add Author method")
    void addAuthor() {
        CreateAuthorRequest request = new CreateAuthorRequest("Lev", "Tols", 2021, "Russia", "russian");

        when(util.createAuthorFromRequest(request)).thenReturn(author);
        when(repository.save(author)).thenReturn(author);
        when(util.convertToResponse(author)).thenReturn(response);

        AuthorResponse actual = serviceImp.addAuthor(request);

        assertEquals(response, actual);
        verify(repository, times(1)).save(author);
    }

    @Test
    @DisplayName("Test add Author method validation")
    void addAuthorValidation() {
        CreateAuthorRequest request = new CreateAuthorRequest("", "Tols", -13, "", "russian");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);

        assertEquals(3, set.size());
    }

    @Test
    @DisplayName("Test search Author by ID method")
    void searchByID() {

        when(repository.findById(id)).thenReturn(Optional.of(author));
        when(util.convertToResponse(author)).thenReturn(response);

        assertEquals(response, serviceImp.searchByID(id));
    }

    @Test
    @DisplayName("Test delete Author by ID method")
    void deleteAuthor() {
        when(repository.findById(id)).thenReturn(Optional.of(author));
        doNothing().when(repository).delete(author);
        serviceImp.deleteAuthor(id);
        verify(repository,times(1)).delete(author);

    }

    @Test
    void findAllAuthors() {
        when(repository.findAll()).thenReturn(Collections.singletonList(author));
        when(util.convertToResponse(author)).thenReturn(response);
        assertEquals(Collections.singletonList(response), serviceImp.findAllAuthors());
    }

    @Test
    void testSearchByAuthorName() {
        SearchByAuthorNameRequest request = new SearchByAuthorNameRequest("Lev", "Tolstoy");

        when(repository.findByNameAndSurname(request.getName(), request.getSurname())).thenReturn(Optional.of(author));
        when(util.convertToResponse(author)).thenReturn(response);

        assertEquals(response, serviceImp.searchByAuthorName(request));
    }
}