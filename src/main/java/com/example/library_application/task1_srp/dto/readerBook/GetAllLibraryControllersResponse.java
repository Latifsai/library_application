package com.example.library_application.task1_srp.dto.readerBook;

import com.example.library_application.task1_srp.entity.LibraryController;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetAllLibraryControllersResponse {
    private List<LibraryController> controllers;
}
