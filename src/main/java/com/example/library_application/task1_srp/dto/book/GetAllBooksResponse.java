package com.example.library_application.task1_srp.dto.book;

import com.example.library_application.task1_srp.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBooksResponse {
    List<Book> books;
}
