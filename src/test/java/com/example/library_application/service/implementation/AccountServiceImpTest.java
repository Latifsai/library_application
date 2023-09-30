package com.example.library_application.service.implementation;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.account.CreateAccountRequest;
import com.example.library_application.dto.account.UpdateAccountRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.entity.enums.DocumentType;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.repository.AccountRepository;
import com.example.library_application.service.util.AccountUtil;
import com.example.library_application.validation.exeptions.NotFoundException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImpTest {
    @Mock
    private AccountRepository repository;
    @Mock
    private AccountUtil util;
    @InjectMocks
    private AccountServiceImp service;

    private final Account account = EntityCreator.getAccount();
    private final List<Account> list = Collections.singletonList(EntityCreator.getAccount());
    private final AccountResponse response = DTOCreator.getAccountResponse();
    private final String number = "A1B3G5Y7";

    @Test
    @DisplayName("Test create account method")
    void createAccount() {
        CreateAccountRequest request = new CreateAccountRequest("user", "50151832L", "email@.com",
                "address", "phone", DocumentType.IDENTITY_VERIFICATION_DOC);

        when(repository.findAll()).thenReturn(list);
        when(util.createAccount(request, list)).thenReturn(account);
        when(repository.save(account)).thenReturn(account);
        when(util.convertToResponse(account)).thenReturn(response);

        assertEquals(response, service.createAccount(request));
        verify(repository, times(1)).findAll();
        verify(util, times(1)).createAccount(request, list);
        verify(repository, times(1)).save(account);
        verify(util, times(1)).convertToResponse(account);
    }

    @Test
    @DisplayName("Test create account method validation")
    void createAccountValidation() {
        CreateAccountRequest request = new CreateAccountRequest("", "50", "em",
                "", "phone", DocumentType.IDENTITY_VERIFICATION_DOC);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);

        assertEquals(4, set.size());
    }

    @Test
    @DisplayName("Test findByAccountNumber method")
    void findByAccountNumber() {
        when(repository.findByUniqueNumber(number)).thenReturn(Optional.of(account));
        when(util.convertToResponse(account)).thenReturn(response);

        assertEquals(response, service.findByAccountNumber(number));
        verify(repository, times(1)).findByUniqueNumber(number);
        verify(util, times(1)).convertToResponse(account);
    }

    @Test
    @DisplayName("Test deleteAccount method")
    void deleteAccount() {
        when(repository.findByUniqueNumber(number)).thenReturn(Optional.of(account));
        doNothing().when(repository).delete(account);

        service.deleteAccount(number);
        verify(repository, times(1)).findByUniqueNumber(number);
        verify(repository, times(1)).delete(account);
    }

    @Test
    @DisplayName("Test updateAccount method")
    void updateAccount() {
        UpdateAccountRequest request = new UpdateAccountRequest(number, "", "50", "em",
                "", "phone", DocumentType.PASSPORT);

        account.setDocumentType(DocumentType.PASSPORT);

        when(repository.findByUniqueNumber(number)).thenReturn(Optional.of(account));
        when(util.updateAccount(any(),any(), any())).thenReturn(account);
        when(repository.save(account)).thenReturn(account);
        when(util.convertToResponse(account)).thenReturn(response);

        assertEquals(response, service.updateAccount(request));
        verify(repository, times(1)).save(account);
        verify(util, times(1)).convertToResponse(account);
    }

    @Test
    @DisplayName("Test getAllAccount method")
    void getAllAccount() {
        List<AccountResponse> responses = Collections.singletonList(response);

        when(repository.findAll()).thenReturn(list);
        when(util.convertToResponse(account)).thenReturn(response);

        assertEquals(responses, service.getAllAccount());
        verify(repository, times(1)).findAll();
        verify(util, times(1)).convertToResponse(account);
    }

    @Test
    @DisplayName("Test findByNumber method")
    void findByNumber() {
        when(repository.findByUniqueNumber(number)).thenReturn(Optional.of(account));

        assertEquals(account, service.findByNumber(number));
        verify(repository, times(1)).findByUniqueNumber(number);
    }

    @Test
    @DisplayName("Test findByNumber method validation")
    void findByNumberValidation() {
        when(repository.findByUniqueNumber(number)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.findByNumber(number));
    }
}