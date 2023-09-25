package com.example.library_application.dto.reader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReaderResponseForAdmin {
    private List<Reader> readers;
}
