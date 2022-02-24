package com.training.restLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Record entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Record {

    /**
     * Field id
     */
    @Id
    @SequenceGenerator(name = "recordIdSeq", sequenceName = "records_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recordIdSeq")
    @Column(name = "id")
    private Long id;

    /**
     * Field book
     */
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * Field reader
     */
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    /**
     * Field receipt_date
     */
    @Column(name = "receipt_date", nullable = false)
    private LocalDate receiptDate;

    /**
     * Field return_date
     */
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    /**
     * Field real_return_date
     */
    @Column(name = "real_return_date")
    private LocalDate realReturnDate;
}
