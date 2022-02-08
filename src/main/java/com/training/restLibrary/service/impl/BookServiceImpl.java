package com.training.restLibrary.service.impl;

import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        final List<Book> result = (List<Book>) bookRepository.findAll();
        log.info("In getAll - {} books found", result.size());
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
        final Book book = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found book with id " + id));
        log.info("In findById - reader: {} found by id: {}", book, id);
        return book;
    }

    @Override
    public Book update(final Book book, final Long id) {
        bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found book with id " + id));
        book.setId(id);
        bookRepository.save(book);
        log.info("In update - book with id: {} successfully updated", id);
        return book;
    }

    @Override
    public List<Book> findAllByTitleContainingIgnoreCase(final String title) {
        final List<Book> result = bookRepository.findAllByTitleContainingIgnoreCase(title);
        log.info("In findAllByTitleContainingIgnoreCase - {} books found", result.size());
        return result;
    }

    @Override
    public List<Book> findAllByAuthors(final Author author) {
        log.info("In findAllByAuthors found ");
        return bookRepository.findAllByAuthors(author);
    }

    @Override
    public List<Book> findAllByGenreIgnoreCase(final String genre) {
        final List<Book> result = bookRepository.findAllByGenreIgnoreCase(genre);
        log.info("In findAllByGenreIgnoreCase - {} books found", result.size());
        return result;
    }

    @Override
    public List<Book> findAllByAvailability(final boolean availability) {
        return bookRepository.findAllByAvailability(availability);
    }
}
