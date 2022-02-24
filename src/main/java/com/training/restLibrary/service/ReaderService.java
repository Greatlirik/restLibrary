package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;

import java.util.List;

/**
 * CRUD and simple logic operations on Reader
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface ReaderService {
    List<Reader> findAll();

    Reader save(Reader reader);

    void deleteById(Long id);

    Reader findById(Long id);

    Reader update(Reader reader, Long id);

    Book takeBook(Long readerId, Book book);

    Reader returnBook(Long readerId, Book book);
}
