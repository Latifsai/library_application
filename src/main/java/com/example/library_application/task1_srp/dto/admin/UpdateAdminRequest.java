package com.example.library_application.task1_srp.dto.admin;

import lombok.Value;

@Value
public class UpdateAdminRequest {
    Integer id;
    String code;
    String name;
    String email;
    Integer password;
}
