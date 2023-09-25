package com.example.library_application.dto.readerBook;

import com.example.library_application.entity.LibraryController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLibraryControllersResponse {
    private List<LibraryController> controllers;
}
