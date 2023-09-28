package com.example.library_application.service.util;

import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.author.CreateAuthorRequest;
import com.example.library_application.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorUtil {

    public Author createAuthorFromRequest(CreateAuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setYearOfBorn(request.getYearOfBorn());
        author.setCountry(request.getCountry());
        author.setLanguage(request.getLanguage());
        return author;
    }

    public AuthorResponse convertToResponse(Author author){
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .yearOfBorn(author.getYearOfBorn())
                .country(author.getCountry())
                .language(author.getLanguage())
                .build();
    }
}
