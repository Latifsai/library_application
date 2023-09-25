package com.example.library_application.dto.admin;

import lombok.Value;

@Value
public class UpdateAdminResponse {
    Integer id;
    String name;
    String email;
    Integer password;
}
