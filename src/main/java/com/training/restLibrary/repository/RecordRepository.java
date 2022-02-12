package com.training.restLibrary.repository;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RecordRepository extends PagingAndSortingRepository<Record, Long> {
    Page<Record> findAllByReader(Reader reader, Pageable page);

    Page<Record> findAllByBook(Book book, Pageable page);

    Optional<Record> findByReaderAndBookAndRealReturnDateIsNull(Reader reader, Book book);
}
