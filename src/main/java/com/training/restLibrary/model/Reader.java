package com.training.restLibrary.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "reader")
@Data
public class Reader extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "reader_number", nullable = false)
    private Long readerNumber;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "reader_book",
            joinColumns = @JoinColumn(name = "reader_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<Book> books;

}
