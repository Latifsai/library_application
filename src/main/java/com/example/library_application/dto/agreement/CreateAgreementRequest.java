package com.example.library_application.dto.agreement;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class CreateAgreementRequest {
    @Max(value = 20) @Min(value = 6)
    Integer numberLengths;
    @Max(value = 12) @Min(value = 1)
    Integer termMonths;
    @NotBlank(message = "managerNumber must not be null!")
    String managerNumber;
    @NotBlank(message = "bookTitle must not be null!")
    String bookTitle;
    @NotBlank(message = "accountNumber must not be null!")
    String accountNumber;
}
