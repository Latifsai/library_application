package com.example.library_application.task1_srp.repositiry;

import com.example.library_application.task1_srp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitleOrAuthor(String title, String author);
}
