package com.example.library_application.generator;

import com.example.library_application.dto.account.AccountResponse;
import com.example.library_application.dto.agreement.AgreementResponse;
import com.example.library_application.dto.author.AuthorResponse;
import com.example.library_application.dto.book.BookResponse;
import com.example.library_application.dto.book.GetBooksBelongsAuthorResponse;
import com.example.library_application.entity.enums.BookStatus;
import com.example.library_application.entity.enums.DocumentType;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class DTOCreator {

    public static AuthorResponse getAuthorResponse() {
        return AuthorResponse.builder()
                .id(UUID.randomUUID())
                .name("Lev")
                .surname("Tolstoy")
                .yearOfBorn(1969)
                .country("Russia")
                .language("Russian")
                .build();
    }

    public static BookResponse getBookResponse() {
        return BookResponse.builder()
                .id(UUID.randomUUID())
                .title("Fight of Ice and Fire")
                .specialNumberOfBook("46B7BH5")
                .pageAmount(1000)
                .description("The roman about people")
                .yearOfRelease(1970)
                .status(BookStatus.AVAILABLE)
                .frameOfBook("Bestseller")
                .authorName("John Orel")
                .build();
    }

    public static GetBooksBelongsAuthorResponse getBooksBelongsAuthorResponse() {
        return GetBooksBelongsAuthorResponse.builder()
                .authorName("Lev Tolstoy")
                .yearOfBorn(1969)
                .country("Russia")
                .language("rus")
                .listOfBooks(new ArrayList<>())
                .build();
    }

    public static AccountResponse getAccountResponse() {
        return AccountResponse.builder()
                .id(UUID.fromString("435521b3-169d-49fd-b086-4bff4842efde"))
                .uniqueNumber("A1B3G5Y7")
                .username("loismain")
                .password("50151832a")
                .email("lois@gmail.com")
                .address("Lifter Str 43")
                .phoneNumber("+49 176 30069298")
                .documentType(DocumentType.IDENTITY_VERIFICATION_DOC)
                .dateOfCreating(Timestamp.valueOf(LocalDateTime.now()))
                .dateOfUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    public static AgreementResponse getAgreementResponse() {
        return AgreementResponse.builder()
                .id(UUID.fromString("435521b3-169d-49fd-b086-4bff4842efde"))
                .openingDate(Timestamp.valueOf(LocalDateTime.of(2023, 9, 30, 20, 18)))
                .returningDate(Timestamp.valueOf(LocalDateTime.of(2023, 12, 30, 20, 18)))
                .updateDate(Timestamp.valueOf(LocalDateTime.of(2023, 9, 30, 20, 18)))
                .termMonths(8)
                .numberOfAgreement("A1B3N3Y9")
                .managerNumber("46B7BH5")
                .bookTitle("Til")
                .username("lord")
                .build();
    }
}
