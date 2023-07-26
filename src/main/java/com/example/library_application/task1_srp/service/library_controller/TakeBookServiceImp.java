package com.example.library_application.task1_srp.service.library_controller;

import com.example.library_application.task1_srp.dto.readerBook.TakeAndReturnBookDTORequest;
import com.example.library_application.task1_srp.dto.readerBook.TakeBookDTOResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.BookTakeException;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.repositiry.LibraryControllerRepository;
import com.example.library_application.task1_srp.repositiry.ReaderRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.service.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TakeBookServiceImp implements AllService<TakeBookDTOResponse, TakeAndReturnBookDTORequest> {
    private final LibraryControllerRepository controllerRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final Convertor convertor;

    @Override
    public TakeBookDTOResponse execute(TakeAndReturnBookDTORequest request) {
        var reader = readerRepository.findByPersonalCode(request.getPersonalCode());
        var book = bookRepository.findByTitle(request.getTitle());

        if (reader.isEmpty()) {
            throw new NotFoundException(Message.READER_NOT_FOUND_MESSAGE);
        }

        if (book.isEmpty()) {
            throw new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE);
        }

        var libraryController = convertor.convertByTakingBookRequestsToController(request, book.get(), reader.get());
        if (libraryController.getBookReturnDate() == null) {
            controllerRepository.save(libraryController);
            return new TakeBookDTOResponse(book.get().getTitle(), reader.get().getForename(),
                    reader.get().getSurname(), libraryController.getBookOutDate());
        } else {
            throw new BookTakeException(Message.BOOK_NOT_RETURNED_MESSAGE);
        }
    }
}
