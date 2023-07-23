package com.example.library_application.task1_srp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Entity
@Table(name = "readers")
@Data
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "forename")
    @NotNull(message = "Name must not be null!")
    @NotEmpty
    @NotBlank
    private String forename;
    @Column(name = "surname")
    @NotNull(message = "surname must not be null!")
    @NotEmpty
    @NotBlank
    private String surname;
    @Column(name = "personal_code")
    @NotNull(message = "personalCode must not be null!")
    @NotEmpty
    @NotBlank
    private String personalCode;

}
