package com.training.restLibrary.service.impl;

import com.training.restLibrary.exception.ResourceNotFoundException;
import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAll(PageRequest.of(page.orElse(0), 5));
        log.info("In getAll - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Book save(final Book book) {
        bookRepository.save(book);
        log.info("In save - book with id: {} successfully saved", book.getId());
        return book;
    }

    @Override
    public void deleteById(final Long id) {
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
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));
        book.setId(id);
        bookRepository.save(book);
        log.info("In update - book with id: {} successfully updated", id);
        return book;
    }

    @Override
    public Page<Book> findAllByTitleContainingIgnoreCase(final String title, Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAllByTitleContainingIgnoreCase(title, PageRequest.of(page.orElse(0), 5));
        log.info("In findAllByTitleContainingIgnoreCase - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Book> findAllByAuthors(final Author author, Optional<Integer> page) {
        log.info("In findAllByAuthors found ");
        return bookRepository.findAllByAuthors(author, PageRequest.of(page.orElse(0), 5));
    }

    @Override
    public Page<Book> findAllByGenreIgnoreCase(final String genre, Optional<Integer> page) {
        final Page<Book> result = bookRepository.findAllByGenreIgnoreCase(genre, PageRequest.of(page.orElse(0), 5));
        log.info("In findAllByGenreIgnoreCase - {} books found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Book> findAllByAvailability(final boolean availability, Optional<Integer> page) {
        return bookRepository.findAllByAvailability(availability, PageRequest.of(page.orElse(0), 5));
    }

    @Transactional
    @Override
    public Book takeBook(final Long id) {
        final Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found book with id " + id));

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
