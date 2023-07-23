package com.example.library_application.task1_srp.dto.reader;

import com.example.library_application.task1_srp.entity.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReaderResponse {
    private List<Reader> readers;
}
