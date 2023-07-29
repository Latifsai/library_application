package com.example.library_application.dto.reader;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRequest {
    private Integer id;
    private String personalCode;
}
