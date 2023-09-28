package com.example.library_application.service.util;

import java.security.SecureRandom;
import java.util.Random;


public class Generator {
    private final String MATERIALS = "Q1WER2TY3UI4OPA5SD6FG7HJK8LMN9BVCXZ";
    private static Generator instance;

    private Generator() {
    }

    public static Generator getInstance() {
        if (instance == null) {
            return instance = new Generator();
        }
        return instance;
    }

    public String generateNumber(int lengthOfNumber) {
        Random random = new SecureRandom();
        StringBuilder builder = new StringBuilder(lengthOfNumber);
        for (int i = 0; i < lengthOfNumber; i++) {
            builder.append(random.nextInt(lengthOfNumber));
        }
        return builder.toString();
    }
}
