package com.example.library_application.validation.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoreResponse {
    private List<CoreError> errors;

    public boolean hasErrors() {
        if (errors.isEmpty()) {
            return false;
        }
        return true;
    }
}
