package com.example.library_application.task1_srp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "agreements")
public class Agreement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "opening_date",nullable = false)
    private Timestamp openingDate;

    @Column(name = "returning_date",nullable = false)
    private Timestamp returningDate;

    @Column(name = "update_date",nullable = false)
    private Timestamp updateDate;

    @Column(name = "term_months", nullable = false)
    private Integer termMonths;

    @Column(name = "number_of_agreement", nullable = false, unique = true)
    private String numberOfAgreement;

    @Column(name = "manager_number", nullable = false)
    private String managerNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH})
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH})
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return Objects.equals(id, agreement.id) && Objects.equals(openingDate, agreement.openingDate) && Objects.equals(returningDate, agreement.returningDate) && Objects.equals(updateDate, agreement.updateDate) && Objects.equals(termMonths, agreement.termMonths) && Objects.equals(numberOfAgreement, agreement.numberOfAgreement) && Objects.equals(managerNumber, agreement.managerNumber) && Objects.equals(book, agreement.book) && Objects.equals(account, agreement.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, account);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", openingDate=" + openingDate +
                ", returningDate=" + returningDate +
                ", updateDate=" + updateDate +
                ", termMonths=" + termMonths +
                ", numberOfAgreement='" + numberOfAgreement + '\'' +
                ", managerNumber='" + managerNumber + '\'' +
                ", book=" + book +
                ", account=" + account +
                '}';
    }
}
