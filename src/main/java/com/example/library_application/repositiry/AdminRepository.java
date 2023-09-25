package com.example.library_application.repositiry;

import com.example.library_application.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    void deleteAdminById(Integer id);
}
