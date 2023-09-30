package com.example.library_application.dto.agreement;

import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Value
@Builder
public class AgreementResponse {
    UUID id;
    Timestamp openingDate;
    Timestamp returningDate;
    Timestamp updateDate;
    Integer termMonths;
    String numberOfAgreement;
    String managerNumber;
    String bookTitle;
    String username;
}
