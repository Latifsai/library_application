package com.example.library_application.task1_srp.service.admin;

import com.example.library_application.task1_srp.dto.admin.CreateAdminRequest;
import com.example.library_application.task1_srp.dto.admin.CreateAdminResponse;
import com.example.library_application.task1_srp.repositiry.AdminRepository;
import com.example.library_application.task1_srp.service.AllService;
import com.example.library_application.task1_srp.service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateAdminService implements AllService<CreateAdminResponse, CreateAdminRequest> {

    private final AdminRepository repository;
    private final Convertor convertor;

    @Override
    public CreateAdminResponse execute(CreateAdminRequest request) {
        var admin = convertor.convertRequestToAdmin(request);
        repository.save(admin);

        return new CreateAdminResponse(admin.getId(), admin.getName(),
                admin.getEmail(), admin.getPersonalCodeForAdmin(), admin.getPassword());
    }
}
