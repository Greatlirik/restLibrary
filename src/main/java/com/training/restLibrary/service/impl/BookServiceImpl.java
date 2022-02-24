package com.training.restLibrary.service.impl;

import com.training.restLibrary.exception.ResourceNotFoundException;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.repository.AuthorRepository;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Book service implementation
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Page<Book> findAll(Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAll(PageRequest.of(page.orElse(0), 5));

        if (result == null) {
            throw new ResourceNotFoundException("in findAll appeared Exception");
        }

        log.info("In getAll - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Book save(final Book book) {
        if (book == null) {
            throw new ResourceNotFoundException("book is null");
        }
        bookRepository.save(book);
        log.info("In save - book with id: {} successfully saved", book.getId());
        return book;
    }

    @Override
    public void deleteById(final Long id) {
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));
        bookRepository.deleteById(id);
        log.info("In delete - book with id: {} successfully deleted", id);
    }

    @Override
    public Book findById(final Long id) {
        final Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));
        log.info("In findById - reader: {} found by id: {}", book, id);
        return book;
    }

    @Override
    public Book update(final Book book, final Long id) {
        if (book == null) {
            throw new ResourceNotFoundException("book is null");
        }
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));
        book.setId(id);
        bookRepository.save(book);
        log.info("In update - book with id: {} successfully updated", id);
        return book;
    }

    @Override
    public Page<Book> findAllByTitleContainingIgnoreCase(final String title, Optional<Integer> page) {
        final Page<Book> result = bookRepository
                .findAllByTitleContainingIgnoreCase(title, PageRequest.of(page.orElse(0), 5));

        if (result == null) {
            throw new ResourceNotFoundException("in findAllByTitleContainingIgnoreCase appeared Exception");
        }

        log.info("In findAllByTitleContainingIgnoreCase - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Book> findAllByAuthors(final String authorLastName, Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAllByAuthors(
                authorRepository.findByLastNameIgnoringCase(authorLastName)
                        .orElseThrow(() -> new ResourceNotFoundException("There is no author with this lastname"))
                , PageRequest.of(page.orElse(0), 5));

        if (result == null) {
            throw new ResourceNotFoundException("in findAllByAuthors appeared Exception");
        }

        log.info("In findAllByAuthors found - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Book> findAllByGenreIgnoreCase(final String genre, Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAllByGenreIgnoreCase(genre, PageRequest.of(page.orElse(0), 5));

        if (result == null) {
            throw new ResourceNotFoundException("in findAllByGenreIgnoreCase appeared Exception");
        }

        log.info("In findAllByGenreIgnoreCase - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Book> findAllByAvailability(final boolean availability, Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAllByAvailability(availability, PageRequest.of(page.orElse(0), 5));

        if (result == null) {
            throw new ResourceNotFoundException("in findAllByAvailability appeared Exception");
        }

        log.info("In findAllByAvailability - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Book takeBook(final Long id) {
        final Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));

        if (book.getQuantity() > 1) {
            book.setQuantity(book.getQuantity() - 1);
        } else if (book.getQuantity() == 1) {
            book.setQuantity(book.getQuantity() - 1);
            book.setAvailability(false);
        } else {
            throw new ResourceNotFoundException("book are not available");
        }

        bookRepository.save(book);
        return book;
    }

    @Override
    public Book returnBook(final Long id) {
        final Book book = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found book with id " + id));
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        return book;
    }
}
