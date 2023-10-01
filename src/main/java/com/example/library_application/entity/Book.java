package com.example.library_application.entity;

import com.example.library_application.entity.enums.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, length = 60)
    private String title;

    @Column(name = "special_number_of_book",nullable = false, length = 25)
    private String specialNumberOfBook;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "page_amount")
    private Integer pageAmount;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "year_of_release")
    private Integer yearOfRelease;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name = "frame_of_book", nullable = false, length = 69)
    private String frameOfBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(yearOfRelease, book.yearOfRelease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfRelease);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", specialNumberOfBook='" + specialNumberOfBook + '\'' +
                ", author=" + author +
                ", pageAmount=" + pageAmount +
                ", description='" + description + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", status=" + status +
                ", frameOfBook='" + frameOfBook + '\'' +
                '}';
    }
}
