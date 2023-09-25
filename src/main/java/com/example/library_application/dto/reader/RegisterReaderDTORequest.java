package com.example.library_application.dto.reader;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReaderDTORequest {
    @Pattern(regexp = "\\d+(adm)")
    private String adminCode;
    @NotNull(message = "Name must not be null!")
    @NotEmpty(message = "Name must not be empty!")
    @NotBlank(message = "Name must not be blank!")
    private String forename;
    @NotNull(message = "surname must not be null!")
    @NotEmpty(message = "Surname must not be empty!")
    @NotBlank(message = "Surname must not be blank!")
    private String surname;
}
