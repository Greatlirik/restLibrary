package com.training.restLibrary.models.dtos;

import com.training.restLibrary.models.BookEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookDto {

    @NotEmpty(message = "The title is required")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "The genre is required")
    @Column(name="genre", nullable = false)
    private String genre;

    @NotNull(message = "The year  is required")
    @Column(name="year", nullable = false)
    private Integer year;

    @NotNull(message = "The quantity  is required")
    @Column(name="quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "The freedom  is required")
    @Column(name="free", nullable = false)
    private Boolean free;

    public BookEntity toBookEntity() {
        return new BookEntity()
                .setTitle(title)
                .setGenre(genre)
                .setYear(year)
                .setQuantity(quantity)
                .setFree(free);
    }
}
