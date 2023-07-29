package com.example.library_application.repositiry;

import com.example.library_application.entity.LibraryController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryControllerRepository extends JpaRepository<LibraryController, Integer> {
    Optional<LibraryController> findById(Integer id);
    List<LibraryController> findByBook_IdAndBookReturnDateIsNull(Integer id, LocalDateTime bookReturnDate);
}
