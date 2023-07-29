package com.example.library_application.service.admin;

import com.example.library_application.dto.admin.DeleteAdminRequest;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.repositiry.AdminRepository;
import com.example.library_application.dto.admin.DeleteAdminResponse;
import com.example.library_application.service.AllService;
import com.example.library_application.validation.Validator;
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
        if (admin.isPresent()) {
            var response = new DeleteAdminResponse(admin.get().getId(), admin.get().getName(), admin.get().getPersonalCodeForAdmin());
            repository.deleteAdminById(request.getId());
            return response;
        }

        throw new NotFoundException(Message.ADMIN_NOT_CREATED_MESSAGE);
    }
}
