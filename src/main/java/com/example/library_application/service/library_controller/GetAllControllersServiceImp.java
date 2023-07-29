package com.example.library_application.service.library_controller;

import com.example.library_application.dto.readerBook.GetLibraryControllerRequest;
import com.example.library_application.repositiry.LibraryControllerRepository;
import com.example.library_application.dto.readerBook.GetAllLibraryControllersResponse;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAllControllersServiceImp implements AllService<GetAllLibraryControllersResponse, GetLibraryControllerRequest> {

    private final LibraryControllerRepository repository;
    private final Validator validator;

    @Override
    public GetAllLibraryControllersResponse execute(GetLibraryControllerRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        return new GetAllLibraryControllersResponse(repository.findAll());
    }
}
