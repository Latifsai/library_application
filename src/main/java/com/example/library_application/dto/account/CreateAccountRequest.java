package com.example.library_application.dto.account;

import com.example.library_application.entity.enums.DocumentType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class CreateAccountRequest {
    @NotBlank(message = "username must not be blank")
    String username;
    @NotBlank(message = "password must not be blank")
    String password;
    @Email(message = "Must be email")
    String email;
    @NotBlank(message = "Address must not be blank")
    String address;
    @Pattern(regexp = "^(\\+\\d{1,3}[-.\\s]?)?\\(?\\d{1,4}\\)?[-.\\s]?\\d{1,9}[-.\\s]?\\d{1,9}$")
    String phoneNumber;
    DocumentType documentType;
}
