package com.example.library_application.repositiry;

import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitleOrAuthor(String title, Author author);
}
