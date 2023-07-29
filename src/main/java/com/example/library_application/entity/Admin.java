package com.example.library_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "admins")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name can not be null!")
    @NotEmpty(message = "Name must not be empty!")
    @Column(name = "name")
    String name;

    @Column(name = "email")
    @NotNull(message = "E-mail must not be null!")
    @Email(message = "Value is not suitable!")
    String email;
    @Column(name = "personal_code_for_admin")
    @NotNull(message = "PersonalCodeForAdmin must not be null!")
    String personalCodeForAdmin;

    @Column(name = "password")
    @NotNull
    Integer password;
}
