package com.training.restLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book extends BaseEntity{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="genre", nullable = false)
    private String genre;

    @Column(name="year", nullable = false)
    private Integer year;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="quantity", nullable = false)
    private Integer quantity;

    @Column(name="free", nullable = false)
    private Boolean availability;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors;
}
