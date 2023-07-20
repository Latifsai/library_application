package com.example.library_application.task1_srp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class ReaderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "book_out_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime bookOutDate;
    @Column(name = "book_return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime bookReturnDate;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
