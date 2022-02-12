package com.training.restLibrary.service;

import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Page<Book> findAll(Optional<Integer> page);

    Book save(Book book);

    void deleteById(Long id);

    Book findById(Long id);

    Book update(Book book, Long id);

    Page<Book> findAllByTitleContainingIgnoreCase(String title, Optional<Integer> page);

    Page<Book> findAllByAuthors(Author author, Optional<Integer> page);

    Page<Book> findAllByGenreIgnoreCase(String genre, Optional<Integer> page);

    Page<Book> findAllByAvailability(boolean availability, Optional<Integer> page);

    Book takeBook(Long id);

    Book returnBook(Long id);
}
