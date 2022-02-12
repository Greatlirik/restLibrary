package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RecordService {
    Page<Record> findAll(Optional<Integer> page);

    Record save(Record record);

    void deleteById(Long id);

    Record findById(Long id);

    Record update(Record record, Long id);

    Page<Record> findAllByReader(Long readerId, Optional<Integer> page);

    Page<Record> findAllByBook(Long bookId, Optional<Integer> page);

    Record takeBook(Book book, Reader reader);

    Record returnBook(Book book, Reader reader);

    Record findByBookAndReader(Reader reader, Book book);
}
