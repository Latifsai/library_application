package com.example.library_application.service.util;

import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.agreement.CreateAgreementRequest;
import com.example.library_application.dto.agreement.UpdateAgreementRequest;
import com.example.library_application.entity.Account;
import com.example.library_application.entity.Agreement;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.AgreementStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class AgreementUtil {

    public Agreement createAgreement(CreateAgreementRequest request, Book book, Account account) {
        Agreement agreement = new Agreement();
        agreement.setNumberOfAgreement(Generator.getInstance().generateNumber(request.getNumberLengths()));
        agreement.setOpeningDate(Timestamp.valueOf(LocalDateTime.now()));
        agreement.setReturningDate(calculateReturnDate(request.getTermMonths(), agreement.getOpeningDate()));
        agreement.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        agreement.setTermMonths(request.getTermMonths());
        agreement.setManagerNumber(request.getManagerNumber());
        agreement.setStatus(AgreementStatus.ACTIVE);
        agreement.setAccount(account);
        agreement.setBook(book);
        return agreement;
    }

    public AgreementResponse convertToResponse(Agreement agreement) {
        return AgreementResponse.builder()
                .id(agreement.getId())
                .openingDate(agreement.getOpeningDate())
                .returningDate(agreement.getReturningDate())
                .updateDate(agreement.getUpdateDate())
                .termMonths(agreement.getTermMonths())
                .numberOfAgreement(agreement.getNumberOfAgreement())
                .managerNumber(agreement.getManagerNumber())
                .bookTitle(agreement.getBook().getTitle())
                .username(agreement.getAccount().getUsername())
                .build();
    }

    public Agreement updateAgreement(UpdateAgreementRequest request, Agreement agreement, Book book, Account account) {

        if (request.getAddedMonthTerm() != 0 && request.getAddedMonthTerm() != null) {
            agreement.setReturningDate(calculateReturnDate(request.getAddedMonthTerm(), agreement.getReturningDate()));
            agreement.setTermMonths(agreement.getTermMonths() + request.getAddedMonthTerm());
        }

        if (book != null) agreement.setBook(book);
        if (account != null) agreement.setAccount(account);

        agreement.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        return agreement;
    }

    private Timestamp calculateReturnDate(Integer monthTerm, Timestamp timestamp) {
        LocalDateTime date = timestamp.toLocalDateTime();
        return Timestamp.valueOf(date.plusMonths(monthTerm));
    }
}
