package com.example.library_application.task1_srp.service.book.serviceImp;

import com.example.library_application.task1_srp.dto.book.BookResponse;
import com.example.library_application.task1_srp.dto.book.BookDTORequest;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.book.RemoveBookService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class RemoveBookServiceImp implements RemoveBookService {

    private final BookRepository repository;
    private final Convertor convertor;

    @Override
    public BookResponse execute(BookDTORequest request) {
        var bookToDelete = repository.findByTitleOrAuthor(request.getTitle(), request.getAuthor());

        if (bookToDelete.isPresent()) {
            BookResponse response = convertor.convertBookToResponse(bookToDelete.get());
            repository.delete(bookToDelete.get());
            return response;
        }

        throw new NotfoundException(Message.BOOK_NOT_FOUND_MESSAGE);
    }
}
