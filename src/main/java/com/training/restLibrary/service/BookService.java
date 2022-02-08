package com.training.restLibrary.service;

import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Book save(Book book);

    void deleteById(Long id);

    Book findById(Long id);

    Book update(Book book, Long id);

    List<Book> findAllByTitleContainingIgnoreCase(String title);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByGenreIgnoreCase(String genre);

    List<Book> findAllByAvailability(boolean availability);
}
