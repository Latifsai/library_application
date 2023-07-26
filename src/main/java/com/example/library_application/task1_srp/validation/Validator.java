package com.example.library_application.task1_srp.validation;

import com.example.library_application.task1_srp.errors.Message;
import com.example.library_application.task1_srp.errors.exeptions.RightsException;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    public void validationRightsExecution(String criteria) {
        if (!criteria.contains("adm")) {
            throw new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE);
        }
    }

}
