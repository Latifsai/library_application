package com.example.library_application.task1_srp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_controller")
@Data
public class LibraryController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "book_out_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "BookOutDate must not be null!")
    private LocalDateTime bookOutDate;
    @Column(name = "book_return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime bookReturnDate;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
