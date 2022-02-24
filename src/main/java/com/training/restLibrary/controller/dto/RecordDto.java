package com.training.restLibrary.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO for Book
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class RecordDto {

    /**
     * Field id
     */
    @NotNull
    private Long id;

    /**
     * Field bookId
     */
    @NotEmpty
    private Long bookId;

    /**
     * Field readerId
     */
    @NotEmpty
    private Long readerId;

    /**
     * Field receiptDate
     */
    @NotEmpty
    private LocalDate receiptDate;

    /**
     * Field returnDate
     */
    @NotEmpty
    private LocalDate returnDate;

    /**
     * Field realReturnDate
     */
    @NotEmpty
    private LocalDate realReturnDate;
}
