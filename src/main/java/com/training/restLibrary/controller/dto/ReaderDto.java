package com.training.restLibrary.controller.dto;

import com.training.restLibrary.model.Book;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * DTO for Reader
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class ReaderDto {

    /**
     * Field id
     */
    private Long id;

    /**
     * Field fullName
     */
    @NotEmpty
    private String fullName;

    /**
     * Field email
     */
    @NotEmpty
    @Email
    private String email;

    /**
     * Field readerNumber
     */
    @NotNull
    private Long readerNumber;

    /**
     * Field phoneNumber
     */
    @NotNull
    @Digits(fraction = 0, integer = 7)
    private Long phoneNumber;

    /**
     * Field rating
     */
    @NotNull
    private Integer rating;

    /**
     * Field books
     */
    private Set<Book> books;
}
