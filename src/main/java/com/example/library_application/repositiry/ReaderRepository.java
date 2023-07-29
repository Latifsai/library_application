package com.example.library_application.repositiry;

import com.example.library_application.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    Optional<Reader> findByPersonalCode(String code);
}
