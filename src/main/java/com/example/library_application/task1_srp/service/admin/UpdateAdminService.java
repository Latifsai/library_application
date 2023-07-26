package com.example.library_application.task1_srp.service.admin;

import com.example.library_application.task1_srp.dto.admin.UpdateAdminRequest;
import com.example.library_application.task1_srp.dto.admin.UpdateAdminResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.AdminRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.service.util.Convertor;
import com.example.library_application.task1_srp.validation.Validator;
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
                    adminToChange.getEmail(), adminToChange.getPersonalCodeForAdmin(),
                    adminToChange.getPassword());
        }
        throw new NotFoundException(Message.ADMIN_NOT_RETURNED_MESSAGE);
    }
}
