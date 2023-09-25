package com.example.library_application.task1_srp.repositiry;

import com.example.library_application.task1_srp.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
}
