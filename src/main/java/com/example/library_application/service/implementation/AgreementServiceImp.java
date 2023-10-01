package com.example.library_application.service.implementation;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.agreement.CreateAgreementRequest;
import com.example.library_application.dto.agreement.UpdateAgreementRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.entity.Agreement;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.AgreementStatus;
import com.example.library_application.repository.AgreementRepository;
import com.example.library_application.service.AgreementService;
import com.example.library_application.service.util.AgreementUtil;
import com.example.library_application.validation.ValidationMessage;
import com.example.library_application.validation.exeptions.BookTakingException;
import com.example.library_application.validation.exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.library_application.entity.enums.BookStatus.AVAILABLE;

@Service
@RequiredArgsConstructor
public class AgreementServiceImp implements AgreementService {

    private final AgreementRepository repository;
    private final AgreementUtil util;
    private final BookServiceImp bookService;
    private final AccountServiceImp accountService;

    @Override
    public AgreementResponse createAgreement(CreateAgreementRequest request) {
        Book book = bookService.findBookByTitle(request.getBookTitle());

        if (!book.getStatus().equals(AVAILABLE)) {
            throw new BookTakingException(ValidationMessage.BOOK_IS_INACCESSIBLE_MESSAGE + request.getBookTitle());
        }

        Account account = accountService.findByNumber(request.getAccountNumber());
        Agreement agreement = util.createAgreement(request, book, account);
        repository.save(agreement);
        return util.convertToResponse(agreement);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgreementResponse> gelAllAgreements() {
        return repository.findAll().stream()
                .map(util::convertToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AgreementResponse findByAgreementNumber(String number) {
        Agreement agreement = findByNumber(number);
        return util.convertToResponse(agreement);
    }

    @Override
    public void deleteAgreement(String number) {
        Agreement agreement = findByNumber(number);
        repository.delete(agreement);
    }

    @Override
    public AgreementResponse updateAgreement(UpdateAgreementRequest request) {
        Book book = bookService.findBookByTitle(request.getBookTitle());
        Account account = accountService.findByNumber(request.getAccountNumber());
        Agreement agreement = findByNumber(request.getAgreementNumber());

        Agreement updatedAccount = util.updateAgreement(request, agreement, book, account);
        repository.save(updatedAccount);
        return util.convertToResponse(updatedAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgreementResponse> getAllAgreementsByStatus(AgreementStatus status) {
        return repository.findAllByStatus(status).stream()
                .map(util::convertToResponse)
                .toList();
    }

    private Agreement findByNumber(String number) {
        return repository.findByNumberOfAgreement(number)
                .orElseThrow(() -> new NotFoundException(ValidationMessage.NOT_FOUND_AGREEMENT_MESSAGE + number));
    }

}
