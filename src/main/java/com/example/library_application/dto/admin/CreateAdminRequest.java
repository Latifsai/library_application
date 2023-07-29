package com.example.library_application.dto.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class CreateAdminRequest {
    @NotNull
    @NotEmpty
    String name;
    @Email
    String email;
    @NotNull
    Integer password;
}
