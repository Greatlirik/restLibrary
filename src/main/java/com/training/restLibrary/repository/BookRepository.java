package com.training.restLibrary.repository;


import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Page<Book> findAllByTitleContainingIgnoreCase(String title, Pageable page);

    Page<Book> findAllByAuthors(Author author, Pageable page);

    Page<Book> findAllByGenreIgnoreCase(String genre, Pageable page);

    Page<Book> findAllByAvailability(boolean availability, Pageable page);
}
