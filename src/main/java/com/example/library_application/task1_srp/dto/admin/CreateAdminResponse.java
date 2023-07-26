package com.example.library_application.task1_srp.dto.admin;

import lombok.Value;

@Value
public class CreateAdminResponse {
    Integer id;
    String name;
    String email;
    String code;
    Integer password;
}
