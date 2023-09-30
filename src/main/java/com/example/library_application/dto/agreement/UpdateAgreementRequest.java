package com.example.library_application.dto.agreement;

import lombok.Value;

/**
 * Update is to change term, Book or Account
 */
@Value
public class UpdateAgreementRequest {
    String agreementNumber;
    Integer addedMonthTerm;
    String bookTitle;
    String accountNumber;

}
