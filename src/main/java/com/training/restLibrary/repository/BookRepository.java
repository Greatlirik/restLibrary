package com.training.restLibrary.repository;


import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAllByTitleContainingIgnoreCase(String title);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByGenreIgnoreCase(String genre);

    List<Book> findAllByAvailability(boolean availability);
}
