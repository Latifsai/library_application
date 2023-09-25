package com.example.library_application.dto.admin;

import com.example.library_application.entity.Admin;
import lombok.Value;

import java.util.List;

@Value
public class GetAllAdminsResponse {
    List<Admin> admins;
}
