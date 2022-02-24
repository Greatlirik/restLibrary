package com.training.restLibrary.repository;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Record Repository
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface RecordRepository extends PagingAndSortingRepository<Record, Long> {
    /**
     * Find all records, where was given reader
     *
     * @param reader
     * @param page
     * @return Page<Record>
     */
    Page<Record> findAllByReader(Reader reader, Pageable page);

    /**
     * Find all records, where was given book
     *
     * @param book
     * @param page
     * @return Page<Record>
     */
    Page<Record> findAllByBook(Book book, Pageable page);

    /**
     * find record with given params for use in more complex logic
     *
     * @param reader
     * @param book
     * @return Optional<Record>
     */
    Optional<Record> findByReaderAndBookAndRealReturnDateIsNull(Reader reader, Book book);
}
