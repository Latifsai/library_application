package com.example.library_application.repository;

import com.example.library_application.entity.Author;
import com.example.library_application.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findByTitle(String title);
    List<Book> findAllByAuthor(Author author);
}
