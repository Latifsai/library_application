package com.example.library_application.dto.readerBook;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeAndReturnBookDTORequest {
    @Pattern(regexp = "\\d")
    private String personalCode;
    @NotNull
    @NotEmpty
    private String title;


}
