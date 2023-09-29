package com.example.library_application.dto.account;

import com.example.library_application.entity.enums.DocumentType;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Value
public class AccountResponse {
    UUID id;
    String uniqueNumber;
    String username;
    String password;
    String email;
    String address;
    String phoneNumber;
    DocumentType documentType;
    Timestamp dateOfCreating;
    Timestamp dateOfUpdate;
}
