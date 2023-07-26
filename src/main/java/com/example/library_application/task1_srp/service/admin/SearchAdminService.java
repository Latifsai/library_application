package com.example.library_application.task1_srp.service.admin;

import com.example.library_application.task1_srp.dto.admin.SearchAdminRequest;
import com.example.library_application.task1_srp.dto.admin.SearchAdminResponse;
import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.NotFoundException;
import com.example.library_application.task1_srp.repositiry.AdminRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchAdminService implements AllService<SearchAdminResponse, SearchAdminRequest> {

    private final AdminRepository repository;
    private final Validator validator;

    @Override
    public SearchAdminResponse execute(SearchAdminRequest searchAdminRequest) {
        validator.validationRightsExecution(searchAdminRequest.getPersonalCode());

        var admin = repository.findById(searchAdminRequest.getId());
        if (admin.isPresent()) {
            return new SearchAdminResponse(admin.get().getPersonalCodeForAdmin(),admin.get().getId(),
                    admin.get().getName(), admin.get().getEmail());
        }
        throw new NotFoundException(Message.ADMIN_NOT_RETURNED_MESSAGE);
    }
}
