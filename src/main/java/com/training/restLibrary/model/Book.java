package com.training.restLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

/**
 * Book entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {

    /**
     * Field id
     */
    @Id
    @SequenceGenerator(name = "bookIdSeq", sequenceName = "books_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookIdSeq")
    @Column(name = "id")
    private Long id;

    /**
     * Field title
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Field genre
     */
    @Column(name = "genre", nullable = false)
    private String genre;

    /**
     * Field year
     */
    @Column(name = "year", nullable = false)
    private Integer year;

    /**
     * Field description
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Field quantity
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * Field availability
     */
    @Column(name = "free", nullable = false)
    private boolean availability;

    /**
     * Field authors
     */
    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors;
}
