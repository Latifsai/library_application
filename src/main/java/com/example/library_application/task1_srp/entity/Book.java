package com.example.library_application.task1_srp.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NotNull(message = "Title must not be null!")
    @NotBlank
    @NotEmpty(message = "Title must not be empty!")
    private String title;

    @Column(name = "author")
    @NotNull(message = "Author must not be null!")
    @NotBlank
    @NotEmpty(message = "Author must not be empty!")
    private String author;

    @Column(name = "page_amount")
    private Integer pageAmount;

    @Column(name = "description")
    private String description;
}
