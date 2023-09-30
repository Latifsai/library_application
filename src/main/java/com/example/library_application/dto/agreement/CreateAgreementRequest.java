package com.example.library_application.dto.agreement;

import lombok.Value;

@Value
public class CreateAgreementRequest {
    Integer numberLengths;
    Integer termMonths;
    String managerNumber;
    String bookTitle;
    String accountNumber;
}
