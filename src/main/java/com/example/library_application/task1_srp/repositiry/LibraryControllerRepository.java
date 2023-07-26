package com.example.library_application.task1_srp.repositiry;

import com.example.library_application.task1_srp.entity.LibraryController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryControllerRepository extends JpaRepository<LibraryController, Integer> {
    Optional<LibraryController> findById(Integer id);
}
