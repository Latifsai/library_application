package com.example.library_application.service;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.agreement.CreateAgreementRequest;
import com.example.library_application.dto.agreement.UpdateAgreementRequest;
import com.example.library_application.entity.enums.AgreementStatus;

import java.util.List;

public interface AgreementService {
    AgreementResponse createAgreement(CreateAgreementRequest request);
    List<AgreementResponse> gelAllAgreements();
    AgreementResponse findByAgreementNumber(String number);
    void deleteAgreement(String number);
    AgreementResponse updateAgreement(UpdateAgreementRequest request);
    List<AgreementResponse> getAllAgreementsByStatus(AgreementStatus status);
}
