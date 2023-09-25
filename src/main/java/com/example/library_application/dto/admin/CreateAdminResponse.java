package com.example.library_application.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateAdminResponse {
    Integer id;
    String name;
    String email;
    String code;
    Integer password;
}
