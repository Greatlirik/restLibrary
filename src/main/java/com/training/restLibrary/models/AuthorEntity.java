package com.training.restLibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AuthorEntity extends BaseEntity{

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //TODO add many to many here with books
}
