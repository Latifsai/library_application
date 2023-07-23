package com.example.library_application.task1_srp.dto.reader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReaderResponse {
    private Integer id;
    private String forename;
    private String surname;
}
