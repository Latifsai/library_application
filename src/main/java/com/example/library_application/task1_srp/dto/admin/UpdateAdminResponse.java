package com.example.library_application.task1_srp.dto.admin;

import lombok.Value;

@Value
public class UpdateAdminResponse {
    Integer id;
    String name;
    String email;
    String code;
    Integer password;
}
