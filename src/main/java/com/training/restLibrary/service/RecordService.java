package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * CRUD and simple logic operations on Record
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface RecordService {
    Page<Record> findAll(Optional<Integer> page, Long bookId, Long readerId);

    Record save(Record record);

    void deleteById(Long id);

    Record findById(Long id);

    Record update(Record record, Long id);

    Record takeBook(Book book, Reader reader);

    Record returnBook(Book book, Reader reader);

    Record findByBookAndReader(Reader reader, Book book);
}
