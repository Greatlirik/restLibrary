package com.training.restLibrary.repository;


import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Book Repository
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    /**
     * find all books with given title using pagination
     *
     * @param title
     * @param page
     * @return Page<Book>
     */
    Page<Book> findAllByTitleContainingIgnoreCase(String title, Pageable page);

    /**
     * find all books with given author using pagination
     *
     * @param author
     * @param page
     * @return Page<Book>
     */
    Page<Book> findAllByAuthors(Author author, Pageable page);

    /**
     * find all books with given genre using pagination
     *
     * @param genre
     * @param page
     * @return Page<Book>
     */
    Page<Book> findAllByGenreIgnoreCase(String genre, Pageable page);

    /**
     * find all books with availability using pagination
     *
     * @param availability
     * @param page
     * @return Page<Book>
     */
    Page<Book> findAllByAvailability(boolean availability, Pageable page);
}
