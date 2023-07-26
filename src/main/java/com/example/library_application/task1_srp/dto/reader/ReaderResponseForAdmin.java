package com.example.library_application.task1_srp.dto.reader;

import lombok.Value;

@Value
public class ReaderResponseForAdmin {
    Integer id;
    String forename;
    String surname;
    String code;
}
