package com.example.library_application.generator;

import com.example.library_application.entity.Admin;
import com.example.library_application.entity.Book;
import com.example.library_application.entity.LibraryController;
import com.example.library_application.entity.Reader;

import java.time.LocalDateTime;
import java.time.Month;

public class EntityCreator {
    public static Admin getAdmin() {
        var admin = new Admin();
        admin.setId(1);
        admin.setName("John");
        admin.setEmail("admin@mail.com");
        admin.setPassword(2125);
        return admin;
    }

    public static Book getBook() {
        return new Book(1, "Lolita", "Leo Tolstoy", 560, "");
    }

    public static Reader getReader () {
        return new Reader(1, "Oleg", "Legov", "58429896454");
    }

    public static LibraryController getLibraryController() {
        var controller = new LibraryController();
        controller.setId(1);
        controller.setBookOutDate(LocalDateTime.of(2022, Month.AUGUST,3,14,32,32));
        controller.setBookReturnDate(null);
        controller.setBook(getBook());
        controller.setReader(getReader());
        return controller;
    }

}
