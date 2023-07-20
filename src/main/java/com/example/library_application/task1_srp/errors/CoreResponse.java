package com.example.library_application.task1_srp.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class CoreResponse {
    private List<CoreError> errors = new ArrayList<>();

    public boolean hasErrors() {
        if (errors.isEmpty()) {
            return false;
        }
        return true;
    }
}
