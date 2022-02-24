package com.training.restLibrary.controller.dto;

import com.training.restLibrary.model.Author;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * DTO for Book
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class BookDto {

    /**
     * Field id
     */
    private Long id;

    /**
     * Field title
     */
    @NotEmpty(message = "The title is required")
    private String title;

    /**
     * Field genre
     */
    @NotEmpty(message = "The genre is required")
    private String genre;

    /**
     * Field year
     */
    @NotNull(message = "The year  is required")
    private Integer year;

    /**
     * Field description
     */
    @NotEmpty(message = "The year  is required")
    private String description;

    /**
     * Field quantity
     */
    @NotNull(message = "The quantity  is required")
    private Integer quantity;

    /**
     * Field available
     */
    @NotNull(message = "The freedom  is required")
    private boolean available;

    /**
     * Field authors
     */
    @NotEmpty(message = "The authors is required")
    private Set<Author> authors;
}
