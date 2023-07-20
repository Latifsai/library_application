package com.example.library_application.task1_srp.service.book;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
@Transactional
public class GetBookService {



    public GetAllBookResponse execute() {
        return new GetAllBookResponse(database.getLibrary());
    }
}
