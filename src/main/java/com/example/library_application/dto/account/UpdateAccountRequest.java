package com.example.library_application.dto.account;

import com.example.library_application.entity.enums.DocumentType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.util.UUID;

@Value
public class UpdateAccountRequest {
    String number;
    String username;
    String password;
    @Email
    String email;
    String address;
    @Pattern(regexp = "^(\\+\\d{1,3}[-.\\s]?)?\\(?\\d{1,4}\\)?[-.\\s]?\\d{1,9}[-.\\s]?\\d{1,9}$")
    String phoneNumber;
    DocumentType documentType;
}
