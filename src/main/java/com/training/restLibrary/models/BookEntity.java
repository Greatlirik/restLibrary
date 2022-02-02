package com.training.restLibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BookEntity extends BaseEntity{

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="genre", nullable = false)
    private String genre;
    @Column(name="year", nullable = false)
    private Integer year;
    @Column(name="quantity", nullable = false)
    private Integer quantity;
    @Column(name="free", nullable = false)
    private Boolean free;



    //TODO add many to many here with authors
}
