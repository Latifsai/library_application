package com.example.library_application.task1_srp.service.admin;

import com.example.library_application.task1_srp.dto.admin.DeleteAdminRequest;
import com.example.library_application.task1_srp.dto.admin.DeleteAdminResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.RightsException;
import com.example.library_application.task1_srp.repositiry.AdminRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAdminsService implements AllService<DeleteAdminResponse, DeleteAdminRequest> {

    private final AdminRepository repository;
    private final Validator validator;

    @Override
    public DeleteAdminResponse execute(DeleteAdminRequest request) {
        validator.validationRightsExecution(request.getCode());

        var admin = repository.findById(request.getId());
        var response = new DeleteAdminResponse(admin.get().getId(), admin.get().getName(), admin.get().getPersonalCodeForAdmin());
        repository.deleteAdminById(request.getId());
        return response;
    }
}
