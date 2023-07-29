package com.example.library_application.validation;

import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.RightsException;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    public void validationRightsExecution(String criteria) {
        if (!criteria.contains("adm")) {
            throw new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE);
        }
    }

}
