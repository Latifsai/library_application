package com.example.library_application.task1_srp.service.book.serviceImp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Transactional
public class FindBookServiceImp {



//    public FindBookResponse execute(FindBookRequest request) {
//        FindBookRequestValidator validator = new FindBookRequestValidator();
//        List<CoreError> errors = validator.validate(request);
//
//        if (!errors.isEmpty()) {
//            return new FindBookResponse(errors);
//        }
//
//        return new FindBookResponse(database.findElementById(request.getId()).get());
//    }
}
