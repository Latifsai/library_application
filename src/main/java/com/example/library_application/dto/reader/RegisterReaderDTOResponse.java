package com.example.library_application.dto.reader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReaderDTOResponse {
    private Integer id;
    private String forename;
    private String surname;
}
