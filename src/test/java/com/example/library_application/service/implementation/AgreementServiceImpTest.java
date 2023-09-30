package com.example.library_application.service.implementation;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.entity.Agreement;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.repository.AgreementRepository;
import com.example.library_application.service.util.AgreementUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgreementServiceImpTest {
    @Mock
    private AgreementRepository repository;
    @Mock
    private AgreementUtil util;
    @Mock
    private BookServiceImp bookService;
    @Mock
    private AccountServiceImp accountService;
    @InjectMocks
    private AgreementServiceImp agreementService;

    private final Agreement agreement = EntityCreator.getAgreement();
    private final AgreementResponse response = DTOCreator.getAgreementResponse();

    @Test
    void createAgreement() {
    }

    @Test
    @DisplayName("Test gelAllAgreements method")
    void gelAllAgreements() {
        var list = Collections.singletonList(agreement);

        when(repository.findAll()).thenReturn(list);
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(Collections.singletonList(response), agreementService.gelAllAgreements());
    }

    @Test
    void findByAgreementNumber() {
    }

    @Test
    void deleteAgreement() {
    }

    @Test
    void updateAgreement() {
    }

    @Test
    void getAllAgreementsByStatus() {
    }
}