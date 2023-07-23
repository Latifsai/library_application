package com.example.library_application.task1_srp.repositiry;

import com.example.library_application.task1_srp.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    Optional<Reader> findByPersonalCode(String code);
}
