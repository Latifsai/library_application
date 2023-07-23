package com.example.library_application.task1_srp.service.book.serviceImp;

import com.example.library_application.task1_srp.dto.book.UpdateBookDTORequest;
import com.example.library_application.task1_srp.dto.book.UpdateBookDTOResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotfoundException;
import com.example.library_application.task1_srp.repositiry.BookRepository;
import com.example.library_application.task1_srp.service.book.UpdateService;
import com.example.library_application.task1_srp.service.util.Convertor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateBookServiceImp implements UpdateService {
    private final BookRepository repository;
    private final Convertor convertor;
    @Override
    public UpdateBookDTOResponse execute(UpdateBookDTORequest request) {
        var book = repository.findByTitle(request.getTitle());

        if (book.isPresent()){
            var updatedBook = book.map(b -> convertor.updateBook(b,request)).get();
            repository.save(updatedBook);
            return convertor.convertBookToUpdateResponse(updatedBook);
        }

        throw new NotfoundException(Message.BOOK_NOT_FOUND_MESSAGE);
    }
}
