package com.example.library_application.generator;

import com.example.library_application.entity.Account;
import com.example.library_application.entity.Agreement;
import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.enums.AgreementStatus;
import com.example.library_application.entity.enums.BookStatus;
import com.example.library_application.entity.enums.DocumentType;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

public class EntityCreator {

    public static Author getAuthor() {
        return new Author(
                UUID.fromString("435521b3-169d-49fd-b086-4bff4842efde"),
                "Lev",
                "Tolstoy",
                1969,
                "Russia",
                "Russian",
                Collections.emptyList()
                );
    }

    public static Book getBook() {
        return new Book(
                UUID.randomUUID(),
                "Fight of Ice and Fire",
                "46B7BH5",
                getAuthor(),
                1000,
                "The roman about people",
                1970,
                BookStatus.AVAILABLE,
                "Bestseller"
        );
    }

    public static Account getAccount() {
        return new Account(
            UUID.fromString("435521b3-169d-49fd-b086-4bff4842efde"),
                "A1B3G5Y7",
                "loismain",
                "50151832a",
                "lois@gmail.com",
                "Lifter Str 43",
                "+49 176 30069298",
                DocumentType.IDENTITY_VERIFICATION_DOC,
                Timestamp.valueOf(LocalDateTime.of(2023, 9, 30 , 20, 18)),
                Timestamp.valueOf(LocalDateTime.of(2023, 9, 30 , 20, 18)),
                Collections.singletonList(getBook()),
                Collections.emptyList()
        );
    }

    public static Agreement getAgreement() {
        return new Agreement(
                UUID.fromString("435521b3-169d-49fd-b086-4bff4842efde"),
                "A1B2G5Y0",
                Timestamp.valueOf(LocalDateTime.of(2023, 9, 30 , 20, 18)),
                Timestamp.valueOf(LocalDateTime.of(2023, 12, 30 , 20, 18)),
                Timestamp.valueOf(LocalDateTime.of(2023, 9, 30 , 20, 18)),
                3,
                "46B7BH5",
                AgreementStatus.ACTIVE,
                getBook(),
                getAccount()
        );
    }

}
