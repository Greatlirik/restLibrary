package com.training.restLibrary.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "record")
@Data
public class Record extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "receipt_date", nullable = false)
    private LocalDate receiptDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "real_return_date")
    private LocalDate realReturnDate;
}
