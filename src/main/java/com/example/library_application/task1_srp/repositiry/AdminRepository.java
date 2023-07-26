package com.example.library_application.task1_srp.repositiry;

import com.example.library_application.task1_srp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    void deleteAdminById(Integer id);
}
