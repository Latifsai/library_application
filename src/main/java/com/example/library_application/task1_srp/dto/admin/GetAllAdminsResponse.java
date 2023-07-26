package com.example.library_application.task1_srp.dto.admin;

import com.example.library_application.task1_srp.entity.Admin;
import lombok.Value;

import java.util.List;

@Value
public class GetAllAdminsResponse {
    List<Admin> admins;
}
