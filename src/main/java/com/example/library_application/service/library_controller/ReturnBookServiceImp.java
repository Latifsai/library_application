package com.example.library_application.service.library_controller;

import com.example.library_application.dto.readerBook.TakeAndReturnBookDTORequest;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.BookRepository;
import com.example.library_application.repositiry.LibraryControllerRepository;
import com.example.library_application.repositiry.ReaderRepository;
import com.example.library_application.service.AllService;
import com.example.library_application.service.util.Convertor;
import com.example.library_application.dto.readerBook.ReturnBookDTOResponse;
import com.example.library_application.errors.Message;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnBookServiceImp implements AllService<ReturnBookDTOResponse, TakeAndReturnBookDTORequest> {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final LibraryControllerRepository libraryControllerRepository;
    private final Convertor convertor;

    @Override
    public ReturnBookDTOResponse execute(TakeAndReturnBookDTORequest request) {

        var book = bookRepository.findByTitle(request.getTitle());
        var reader = readerRepository.findByPersonalCode(request.getPersonalCode());

        if (book.isEmpty()) throw new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE);

        if (reader.isEmpty()) throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);

        var controller = convertor.convertByReturningBookRequestsToController(book.get(), reader.get());
        libraryControllerRepository.save(controller);

        return new ReturnBookDTOResponse(book.get().getTitle(), reader.get().getForename(),
                reader.get().getSurname(), controller.getBookReturnDate());
    }
}
