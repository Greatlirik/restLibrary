package com.training.restLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * Reader entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "reader")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    /**
     * Field id
     */
    @Id
    @SequenceGenerator(name = "readerIdSeq", sequenceName = "readers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "readerIdSeq")
    @Column(name = "id")
    private Long id;

    /**
     * Field first name
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Field last name
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Field email
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Field reader number
     */
    @Column(name = "reader_number", nullable = false)
    private Long readerNumber;

    /**
     * Field phone number
     */
    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    /**
     * Field rating
     */
    @Column(name = "rating", nullable = false)
    private Integer rating;

    /**
     * Field registration date
     */
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    /**
     * Field books
     */
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "reader_book",
            joinColumns = @JoinColumn(name = "reader_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<Book> books;

}
