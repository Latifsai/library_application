package com.example.library_application.dto.admin;

import lombok.Value;

import java.util.List;

@Value
public class GetAllAdminsResponse {
    List<Admin> admins;
}
