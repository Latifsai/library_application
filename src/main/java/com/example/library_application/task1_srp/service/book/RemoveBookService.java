package com.example.library_application.task1_srp.service.book;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;


import java.util.List;
@Component
@AllArgsConstructor
@Transactional
public class RemoveBookService {

//    @Autowired
//    private BookRepository database;
//
//    public RemoveBookResponse execute(RemoveBookRequest request) {
//        RemoveBookRequestValidator validator = new RemoveBookRequestValidator();
//        List<CoreError> errors = validator.validate(request);
//
//
//        if (database.deleteById(request.getIdToRemove())) {
//            return new RemoveBookResponse(true);
//        }
//        return new RemoveBookResponse(errors);
//    }
}
