package com.example.library_application.task1_srp.service.library_controller;

import com.example.library_application.task1_srp.dto.readerBook.DeleteAndSearchControllerRequest;
import com.example.library_application.task1_srp.dto.readerBook.SearchLibraryControllerResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.LibraryControllerRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.validation.Validator;
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
