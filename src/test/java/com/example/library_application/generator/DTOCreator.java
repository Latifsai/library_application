package com.example.library_application.generator;

import com.example.library_application.dto.admin.CreateAdminResponse;
import com.example.library_application.dto.admin.SearchAdminResponse;
import com.example.library_application.dto.admin.UpdateAdminRequest;
import com.example.library_application.dto.admin.UpdateAdminResponse;
import com.example.library_application.dto.book.AddBookRequest;
import com.example.library_application.dto.reader.ResponseForUser;
import com.example.library_application.dto.readerBook.SearchLibraryControllerResponse;

import java.time.LocalDateTime;

public class DTOCreator {

    public static CreateAdminResponse getCreateAdminResponse() {
        return new CreateAdminResponse(1, "Adolf",
                "admin@mail.ru", "43448327437443adm", 2125);

    }

    public static SearchAdminResponse getSearchAdminResponse() {
        return new SearchAdminResponse(1, "43448327437443adm",
                "John", "admin@mail.ru");

    }

    public static UpdateAdminRequest getUpdateRequest() {
        return new UpdateAdminRequest(1, "2394fefe93adm",
                "Ron", "ron@mail.com", null);
    }

    public static UpdateAdminResponse getUpdateResponse() {
        return new UpdateAdminResponse(1, "Ron",
                "ron@mail.com", 2125);
    }

    public static AddBookRequest getAddBookRequest() {
        return new AddBookRequest("34845adci434adm", "Lisa",
                "Alexandr Pushkin", 196,
                "Book of Alexandr Pushkin about love!");
    }

    public static AddBookRequest getAddBookRequestRightsException() {
        return new AddBookRequest("34845adi4", "Lisa",
                "Alexandr Pushkin", 196,
                "Book of Alexandr Pushkin about love!");
    }

    public static AddBookRequest getAddBookRequestValidation() {
        return new AddBookRequest("34845adi4adm", "",
                "Alexandr Pushkin", 0,
                "Book of Alexandr Pushkin about love!");
    }

    public static ResponseForUser getResponseForUser() {
        return new ResponseForUser("John", "Snow");
    }

    public static SearchLibraryControllerResponse getSearchControllerResponse() {
        return new SearchLibraryControllerResponse(1,
                LocalDateTime.of(2023,10,29,15,32,21),
                LocalDateTime.of(2023,12,17,13,12,10),
                1,1);
    }
}
