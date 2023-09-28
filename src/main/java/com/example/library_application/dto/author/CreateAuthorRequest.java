package com.example.library_application.dto.author;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;



@Value
public class CreateAuthorRequest {
    @NotBlank(message = "Name must not be blank")
    String name;
    @NotBlank(message = "surname must not be blank")
    String surname;
    @Max(value = 2023)
    @Min(0)
    Integer yearOfBorn;
    @NotBlank(message = "country must not be blank")
    String country;
    @NotBlank(message = "language must not be blank")
    String language;
}
