package com.example.library_application.service.implementation;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.agreement.CreateAgreementRequest;
import com.example.library_application.dto.agreement.UpdateAgreementRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.entity.Agreement;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.AgreementStatus;
import com.example.library_application.entity.enums.BookStatus;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.repository.AgreementRepository;
import com.example.library_application.service.util.AgreementUtil;
import com.example.library_application.validation.exeptions.BookTakingException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    private final Book book = EntityCreator.getBook();
    private final Account account =EntityCreator.getAccount();
    private final String number = "number";

    @Test
    @DisplayName("Test createAgreement method")
    void createAgreement() {
        CreateAgreementRequest request = new CreateAgreementRequest(10, 3, "manager",
                "title", "account");

        when(bookService.findBookByTitle(request.getBookTitle())).thenReturn(book);
        when(accountService.findByNumber(request.getAccountNumber())).thenReturn(account);
        when(util.createAgreement(request, book, account)).thenReturn(agreement);
        when(repository.save(agreement)).thenReturn(agreement);
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(response, agreementService.createAgreement(request));
        verify(bookService, times(1)).findBookByTitle(request.getBookTitle());
        verify(accountService, times(1)).findByNumber(request.getAccountNumber());
        verify(util, times(1)).createAgreement(request, book, account);
        verify(repository, times(1)).save(agreement);
        verify(util, times(1)).convertToResponse(agreement);
    }

    @Test
    @DisplayName("Test createAgreement method if book is not available")
    void createAgreementBookTakingException() {
        CreateAgreementRequest request = new CreateAgreementRequest(10, 3, "manager",
                "title", "account");
        book.setStatus(BookStatus.INACCESSIBLE);

        when(bookService.findBookByTitle(request.getBookTitle())).thenReturn(book);
        assertThrows(BookTakingException.class,() -> agreementService.createAgreement(request));
    }

    @Test
    @DisplayName("Test createAgreement method validation")
    void createAgreementValidation() {
        CreateAgreementRequest request = new CreateAgreementRequest(3, 0, "   ",
                "", null);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);

        assertEquals(5, set.size());
    }

    @Test
    @DisplayName("Test gelAllAgreements method")
    void gelAllAgreements() {
        var list = Collections.singletonList(agreement);

        when(repository.findAll()).thenReturn(list);
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(Collections.singletonList(response), agreementService.gelAllAgreements());
        verify(repository, times(1)).findAll();
        verify(util, times(1)).convertToResponse(agreement);
    }

    @Test
    @DisplayName("Test findByAgreementNumber method")
    void findByAgreementNumber() {
        when(repository.findByNumberOfAgreement(number)).thenReturn(Optional.of(agreement));
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(response, agreementService.findByAgreementNumber(number));
        verify(repository, times(1)).findByNumberOfAgreement(number);
        verify(util, times(1)).convertToResponse(agreement);
    }

    @Test
    @DisplayName("Test deleteAgreement method")
    void deleteAgreement() {
        when(repository.findByNumberOfAgreement(number)).thenReturn(Optional.of(agreement));
        doNothing().when(repository).delete(agreement);
        agreementService.deleteAgreement(number);
    }

    @Test
    @DisplayName("Test updateAgreement method")
    void updateAgreement() {
        UpdateAgreementRequest request = new UpdateAgreementRequest("number", 2,
                "title", "accNumber");

        when(bookService.findBookByTitle(request.getBookTitle())).thenReturn(book);
        when(accountService.findByNumber(request.getAccountNumber())).thenReturn(account);
        when(repository.findByNumberOfAgreement(number)).thenReturn(Optional.of(agreement));
        when(util.updateAgreement(request, agreement, book, account)).thenReturn(agreement);
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(response, agreementService.updateAgreement(request));
        verify(util, times(1)).updateAgreement(request, agreement, book, account);
        verify(util, times(1)).convertToResponse(agreement);
    }

    @Test
    @DisplayName("Test getAllAgreementsByStatus method")
    void getAllAgreementsByStatus() {
        when(repository.findAllByStatus(AgreementStatus.ACTIVE)).thenReturn(Collections.singletonList(agreement));
        when(util.convertToResponse(agreement)).thenReturn(response);

        assertEquals(Collections.singletonList(response), agreementService.getAllAgreementsByStatus(AgreementStatus.ACTIVE));
    }
}