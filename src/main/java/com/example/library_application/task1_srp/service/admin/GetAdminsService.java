package com.example.library_application.task1_srp.service.admin;

import com.example.library_application.task1_srp.dto.admin.GetAllAdminsRequest;
import com.example.library_application.task1_srp.dto.admin.GetAllAdminsResponse;
import com.example.library_application.task1_srp.repositiry.AdminRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAdminsService implements AllService<GetAllAdminsResponse, GetAllAdminsRequest> {

    private final AdminRepository repository;
    private final Validator validator;

    @Override
    public GetAllAdminsResponse execute(GetAllAdminsRequest request) {
        validator.validationRightsExecution(request.getPersonalCode());
        return new GetAllAdminsResponse(repository.findAll());
    }
}
