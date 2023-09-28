package com.example.library_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "yearOfBorn")
    private Integer yearOfBorn;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "language", nullable = false)
    private String language;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH,})
    private List<Book> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(surname, author.surname)
                && Objects.equals(yearOfBorn, author.yearOfBorn)
                && Objects.equals(country, author.country)
                && Objects.equals(language, author.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, yearOfBorn, country, language);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBorn=" + yearOfBorn +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
