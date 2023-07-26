package com.example.library_application.task1_srp.service.library_controller;

import com.example.library_application.task1_srp.dto.readerBook.DeleteAndSearchControllerRequest;
import com.example.library_application.task1_srp.dto.readerBook.DeleteControllerResponse;
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
public class DeleteLibraryControllerServiceImp implements AllService<DeleteControllerResponse, DeleteAndSearchControllerRequest> {

    private final LibraryControllerRepository repository;
    private final Validator validator;
    @Override
    public DeleteControllerResponse execute(DeleteAndSearchControllerRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        var controller = repository.findById(request.getId());

        if (controller.isPresent()) {
            var response = new DeleteControllerResponse(controller.get().getId());
            repository.delete(controller.get());
            return response;
        }
        throw new NotFoundException(Message.LIBRARY_CONTROLLER_NOT_FOUND_MESSAGE);
    }
}
