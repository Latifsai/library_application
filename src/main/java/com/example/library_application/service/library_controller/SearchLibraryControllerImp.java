package com.example.library_application.service.library_controller;

import com.example.library_application.dto.readerBook.DeleteAndSearchControllerRequest;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.LibraryControllerRepository;
import com.example.library_application.dto.readerBook.SearchLibraryControllerResponse;
import com.example.library_application.errors.Message;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchLibraryControllerImp implements AllService<SearchLibraryControllerResponse, DeleteAndSearchControllerRequest> {

    private final LibraryControllerRepository repository;
    private final Validator validator;

    @Override
    public SearchLibraryControllerResponse execute(DeleteAndSearchControllerRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());

        var controller = repository.findById(request.getId());
        return controller.map(libraryController -> new SearchLibraryControllerResponse(libraryController.getId(),
                        libraryController.getBookOutDate(), libraryController.getBookReturnDate(),
                        libraryController.getBook().getId(), libraryController.getReader().getId()))
                .orElseThrow(() -> new NotFoundException(Message.LIBRARY_CONTROLLER_NOT_RETURNED_MESSAGE));
    }
}
