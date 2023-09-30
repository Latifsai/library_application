package com.example.library_application.repository;

import com.example.library_application.entity.Agreement;
import com.example.library_application.entity.enums.AgreementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, UUID> {
    Optional<Agreement> findByNumberOfAgreement(String number);
    List<Agreement> findAllByStatus(AgreementStatus status);
}
