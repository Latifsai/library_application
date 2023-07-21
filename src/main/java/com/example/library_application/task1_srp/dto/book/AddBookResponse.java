package com.example.library_application.task1_srp.dto.book;

import com.example.library_application.task1_srp.errors.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBookResponse {
    private Integer id;
    private String title;
}
