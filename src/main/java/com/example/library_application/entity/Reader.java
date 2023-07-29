package com.example.library_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "readers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "forename")
    @NotNull(message = "Name must not be null!")
    @NotEmpty(message = "Name must not be empty!")
    @NotBlank(message = "Name must not be blank!")
    private String forename;
    @Column(name = "surname")
    @NotNull(message = "surname must not be null!")
    @NotEmpty(message = "Surname must not be empty!")
    @NotBlank(message = "Surname must not be blank!")
    private String surname;
    @Column(name = "personal_code")
    @NotNull(message = "PersonalCode must not be null!")
    @NotEmpty(message = "PersonalCode must not be empty!")
    @NotBlank(message = "PersonalCode must not be blank!")
    private String personalCode;

}
