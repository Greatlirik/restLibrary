package com.training.restLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Author entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Author {

    /**
     * Field id
     */
    @Id
    @SequenceGenerator(name = "authorIdSeq", sequenceName = "authors_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorIdSeq")
    @Column(name = "id")
    private Long id;

    /**
     * Field first name
     */
    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Field last name
     */
    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

}
