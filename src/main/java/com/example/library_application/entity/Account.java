package com.example.library_application.entity;

import com.example.library_application.entity.Agreement;
import com.example.library_application.task1_srp.entity.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "unique_number", unique = true, nullable = false, length = 50)
    private String uniqueNumber;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "date_of_creating", nullable = false)
    private Timestamp dateOfCreating;

    @Column(name = "date_of_update", nullable = false)
    private Timestamp dateOfUpdate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private com.example.library_application.task1_srp.entity.Book books;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(uniqueNumber, account.uniqueNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", documentType=" + documentType +
                ", dateOfCreating=" + dateOfCreating +
                ", dateOfUpdate=" + dateOfUpdate +
                '}';
    }
}
