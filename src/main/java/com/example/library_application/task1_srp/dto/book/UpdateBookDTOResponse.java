package com.example.library_application.task1_srp.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateBookDTOResponse {
    private String title;
    private Integer pageAmount;
    private String description;
}
