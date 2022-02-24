package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * CRUD and simple logic operations on Book
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface BookService {


    /**
     * Find all books with pagination
     *
     * @param page
     * @return page<Book>
     */
    Page<Book> findAll(Optional<Integer> page);

    /**
     * @param book
     * @return
     */
    Book save(Book book);

    /**
     * Delete book with given id
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * Find book with given id
     *
     * @param id
     * @return book
     */
    Book findById(Long id);

    /**
     * Update given book with given id
     *
     * @param book
     * @param id
     * @return book
     */
    Book update(Book book, Long id);

    /**
     * Find all books with pagination by tittle ignore case
     *
     * @param title
     * @param page
     * @return page<Book>
     */
    Page<Book> findAllByTitleContainingIgnoreCase(String title, Optional<Integer> page);

    /**
     * Find all books with pagination by author
     *
     * @param author
     * @param page
     * @return page<Book>
     */
    Page<Book> findAllByAuthors(final String authorLastName, Optional<Integer> page);

    Page<Book> findAllByGenreIgnoreCase(String genre, Optional<Integer> page);

    Page<Book> findAllByAvailability(boolean availability, Optional<Integer> page);

    Book takeBook(Long id);

    Book returnBook(Long id);
}
