package com.example.library_application.service.admin;

import com.example.library_application.dto.admin.UpdateAdminRequest;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.service.util.Convertor;
import com.example.library_application.dto.admin.UpdateAdminResponse;
import com.example.library_application.errors.Message;
import com.example.library_application.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAdminService implements AllService<UpdateAdminResponse, UpdateAdminRequest> {

    private final AdminRepository repository;
    private final Validator validator;
    private final Convertor convertor;

    @Override
    public UpdateAdminResponse execute(UpdateAdminRequest request) {
        validator.validationRightsExecution(request.getCode());

        var admin = repository.findById(request.getId());
        if (admin.isPresent()) {
            var adminToChange = convertor.updateAdmin(admin.get(), request);
            repository.save(adminToChange);
            return new UpdateAdminResponse(adminToChange.getId(), adminToChange.getName(),
                    adminToChange.getEmail(), adminToChange.getPassword());
        }

        throw new NotFoundException(Message.ADMIN_NOT_CREATED_MESSAGE);
    }
}
