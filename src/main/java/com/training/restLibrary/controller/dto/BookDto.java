package com.training.restLibrary.controller.dto;

import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Accessors(chain = true)
public class BookDto {

    @NotNull
    private Long id;

    @NotEmpty(message = "The title is required")
    private String title;

    @NotEmpty(message = "The genre is required")
    private String genre;

    @NotNull(message = "The year  is required")
    private Integer year;

    @NotEmpty(message = "The year  is required")
    private String description;

    @NotNull(message = "The quantity  is required")
    private Integer quantity;

    @NotNull(message = "The freedom  is required")
    private Boolean available;

    @NotEmpty(message = "The authors is required")
    private Set<Author> authors;
}
