package com.example.library_application.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBookRequest {
    private String personalCode;
    @NotNull(message = "Title must not be null!")
    @NotBlank(message = "Title must not be blank!")
    @NotEmpty(message = "Title must not be empty!")
    private String title;
    @NotNull(message = "Author must not be null!")
    @NotBlank(message = "Author must not be blank!")
    @NotEmpty(message = "Author must not be empty!")
    private String author;
    @PositiveOrZero
    private Integer pageAmount;
    private String description;
}
