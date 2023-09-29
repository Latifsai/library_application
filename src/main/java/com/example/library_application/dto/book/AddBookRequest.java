package com.example.library_application.dto.book;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.util.UUID;

@Value
public class AddBookRequest {

    @NotBlank(message = "Title must not be blank!")
    String title;
    @NotNull(message = "author ID must not be null!")
    UUID authorID;
    @Positive(message = "pageAmount must positive!")
    Integer pageAmount;
    @NotBlank(message = "Description must not be blank!")
    String description;
    @Min(5) @Max(20)
    Integer lengthOfNumber;
    @Min(0) @Max(2023)
    Integer yearOfRelease;
    @NotBlank(message = "Frame of book must not be blank!")
    String frameOfBook;
}
