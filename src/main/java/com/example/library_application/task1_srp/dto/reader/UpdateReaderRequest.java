package com.example.library_application.task1_srp.dto.reader;

import lombok.Data;

@Data
public class UpdateReaderRequest {
    private String personalCode;
    private String forename;
    private String surname;
}
