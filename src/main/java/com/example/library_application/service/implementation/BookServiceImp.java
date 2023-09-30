package com.example.library_application.service.implementation;

import com.example.library_application.dto.author.SearchByAuthorNameRequest;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.GetBooksBelongsAuthorResponse;
import com.example.library_application.dto.book.UpdateBookRequest;
import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import com.example.library_application.repository.BookRepository;
import com.example.library_application.service.BookService;
import com.example.library_application.service.util.BookUtil;
import com.example.library_application.validation.ValidationMessage;
import com.example.library_application.validation.exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final BookUtil util;
    private final AuthorServiceImp authorServiceImp;
    private final BookRepository repository;

    @Override
    public BookResponse addBook(AddBookRequest request) {
        Book book = util.createBook(request,authorServiceImp.findAuthorByID(request.getAuthorID()));
        repository.save(book);
        return util.getResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse findBookByID(UUID id) {
        Book book = searchByID(id);
        return util.getResponse(book);
    }

    @Override
    public BookResponse updateBook(UpdateBookRequest request) {
        Book book = searchByID(request.getId());
        Book updatedBook = util.update(request, book);
        repository.save(updatedBook);
        return util.getResponse(updatedBook);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse findByTitle(String title) {
        Book book = repository.findByTitle(title)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_BOOK_MESSAGE + title));
        return util.getResponse(book);
    }


    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks() {
        return repository.findAll().stream()
                .map(util::getResponse)
                .toList();
    }

    @Override
    public GetBooksBelongsAuthorResponse getAllBooksBelongsAuthor(SearchByAuthorNameRequest request) {
        Author author = authorServiceImp.findByName(request.getName(), request.getSurname());
        List<Book> list = repository.findAllByAuthor(author);
        return util.getResponseBelongAuthor(author, list);
    }

    private Book searchByID(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_BOOK_MESSAGE + id));
    }

    public Book findBookByTitle(String title) {
        return repository.findByTitle(title)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_BOOK_MESSAGE + title));
    }
}
