package com.example.library_application.service.implementation;

import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.UpdateBookRequest;
import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import com.example.library_application.validation.exeptions.NotFoundException;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.repository.BookRepository;
import com.example.library_application.service.util.BookUtil;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImpTest {

    @Mock
    private BookUtil util;
    @Mock
    private AuthorServiceImp authorServiceImp;
    @Mock
    private BookRepository repository;
    @InjectMocks
    private BookServiceImp bookServiceImp;

    private final Book book = EntityCreator.getBook();
    private final Author author = EntityCreator.getAuthor();
    private final BookResponse response = DTOCreator.getBookResponse();

    @Test
    @DisplayName("Test add book method")
    void addBook() {
        AddBookRequest request = new AddBookRequest("Title", UUID.randomUUID(), 120, "desc", 10,
                1960, "frame");

        when(authorServiceImp.findAuthorByID(request.getAuthorID())).thenReturn(author);
        when(util.createBook(request, author)).thenReturn(book);
        when(repository.save(book)).thenReturn(book);
        when(util.getResponse(book)).thenReturn(response);

        assertEquals(response, bookServiceImp.addBook(request));
        verify(util, times(1)).createBook(request, author);
        verify(repository, times(1)).save(book);
        verify(util, times(1)).getResponse(book);
    }

    @Test
    @DisplayName("Test add book method validation")
    void addBookValidation() {
        AddBookRequest request = new AddBookRequest("", UUID.randomUUID(), 0, "", 10,
                1960, null);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);

        assertEquals(4, set.size());
    }

    @Test
    @DisplayName("Test findBookByID method")
    void findBookByID() {
        when(repository.findById(UUID.fromString("491a0112-575d-4c5a-804d-eefc1da3362a"))).thenReturn(Optional.of(book));
        when(util.getResponse(book)).thenReturn(response);

        assertEquals(response, bookServiceImp.findBookByID(UUID.fromString("491a0112-575d-4c5a-804d-eefc1da3362a")));
    }

    @Test
    @DisplayName("Test updateBook method")
    void updateBook() {
        UpdateBookRequest request = new UpdateBookRequest(UUID.fromString("4a1f6e18-580a-439f-9b9a-d3bf6c36c6ca"),
                "", 0, null, 2010, null, "best book of year");

        book.setYearOfRelease(request.getYearOfRelease());
        book.setFrameOfBook(request.getFrameOfBook());

        when(repository.findById(UUID.fromString("4a1f6e18-580a-439f-9b9a-d3bf6c36c6ca"))).thenReturn(Optional.of(book));
        when(util.update(request, book)).thenReturn(book);
        when(repository.save(book)).thenReturn(book);
        when(util.getResponse(book)).thenReturn(response);

        assertEquals(response, bookServiceImp.updateBook(request));
        verify(util, times(1)).update(request, book);
        verify(repository, times(1)).save(book);
        verify(util, times(1)).getResponse(book);
    }

    @Test
    @DisplayName("Test findByTitle method")
    void findByTitle() {
        String title =  "title";
        when(repository.findByTitle(title)).thenReturn(Optional.of(book));
        when(util.getResponse(book)).thenReturn(response);

        assertEquals(response, bookServiceImp.findByTitle(title));
        verify(repository, times(1)).findByTitle(title);
        verify(util, times(1)).getResponse(book);
    }

    @Test
    @DisplayName("Test findByTitle method throws NotFoundException")
    void findByTitleException() {
        String title =  "title";
        when(repository.findByTitle(title)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> bookServiceImp.findByTitle(title));
    }

    @Test
    @DisplayName("Test getAllBooks method")
    void getAllBooks() {
        when(repository.findAll()).thenReturn(Collections.singletonList(book));
        when(util.getResponse(book)).thenReturn(response);

        assertEquals(Collections.singletonList(response), bookServiceImp.getAllBooks());
    }

    @Test
    @DisplayName("Test getAllBooksBelongsAuthor method")
    void getAllBooksBelongsAuthor() {
        SearchByAuthorNameRequest request = new SearchByAuthorNameRequest("Les", "Simb");
        List<Book> list = Collections.singletonList(book);
        var response = DTOCreator.getBooksBelongsAuthorResponse();

        when(authorServiceImp.findByName(request.getName(), request.getSurname())).thenReturn(author);
        when(repository.findAllByAuthor(author)).thenReturn(list);
        when(util.getResponseBelongAuthor(author, list)).thenReturn(response);

        assertEquals(response, bookServiceImp.getAllBooksBelongsAuthor(request));
        verify(repository, times(1)).findAllByAuthor(author);
        verify(util, times(1)).getResponseBelongAuthor(author, list);
    }
}