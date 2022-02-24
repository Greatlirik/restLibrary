package com.training.restLibrary.service;

import com.training.restLibrary.model.Author;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.repository.AuthorRepository;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.*;

import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookServiceImpl service;


    Author author1 = new Author(1L, "Alex", "Pushkin");
    Author author2 = new Author(2L, "Vitya", "Kot");

    Set<Author> authors = new HashSet<>(Arrays.asList(author1, author2));

    Book book = new Book(123L, "title", "genre", 2000,
            "description", 10, true, authors);
    Book book2 = new Book(156L, "title2", "genre2", 2002,
            "description2", 12, true, authors);

    List<Book> books = Arrays.asList(book, book2);
    Page<Book> result = new PageImpl<>(books, PageRequest.of(0, 5), books.size());

    @Test
    void findAll() {
        Mockito.when(bookRepository.findAll(PageRequest.of(0, 5))).thenReturn(result);
        service.findAll(Optional.of(0));
        Mockito.verify(bookRepository).findAll(PageRequest.of(0, 5));
    }

    @Test
    void save() {
        service.save(book);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void deleteById() {
        final Long id = 123L;
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        service.deleteById(id);
        Mockito.verify(bookRepository).deleteById(id);
    }

    @Test
    void findById() {
        final Long id = 123L;
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        service.findById(id);
        Mockito.verify(bookRepository).findById(id);
    }

    @Test
    void update() {
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        Book book = new Book(127L, "title", "genre", 2000,
                "description", 10, true, null);
        service.update(book, 123L);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void findAllByTitleContainingIgnoreCase() {
        Mockito.when(bookRepository.findAllByTitleContainingIgnoreCase("title", PageRequest.of(0, 5)))
                .thenReturn(result);
        String title = "title";
        service.findAllByTitleContainingIgnoreCase(title, Optional.of(0));
        Mockito.verify(bookRepository).findAllByTitleContainingIgnoreCase(title, PageRequest.of(0, 5));
    }

    @Test
    void findAllByAuthors() {
        Mockito.when(authorRepository.findByLastNameIgnoringCase("Pushkin")).thenReturn(Optional.ofNullable(author1));
        Mockito.when(bookRepository.findAllByAuthors(author1, PageRequest.of(0, 5)))
                .thenReturn(result);
        service.findAllByAuthors("Pushkin", Optional.of(0));
        Mockito.verify(bookRepository).findAllByAuthors(author1, PageRequest.of(0, 5));
    }

    @Test
    void findAllByGenreIgnoreCase() {
        Mockito.when(bookRepository.findAllByGenreIgnoreCase("genre", PageRequest.of(0, 5)))
                .thenReturn(result);
        String genre = "genre";
        service.findAllByGenreIgnoreCase(genre, Optional.of(0));
        Mockito.verify(bookRepository).findAllByGenreIgnoreCase(genre, PageRequest.of(0, 5));
    }

    @Test
    void findAllByAvailability() {
        Mockito.when(bookRepository.findAllByAvailability(true, PageRequest.of(0, 5)))
                .thenReturn(result);
        service.findAllByAvailability(true, Optional.of(0));
        Mockito.verify(bookRepository).findAllByAvailability(true, PageRequest.of(0, 5));
    }

    @Test
    void takeBook() {
//        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
//        verify(mock).doSomething(argument.capture());
//        assertEquals("John", argument.getValue().getName());

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        final Long id = 123L;
        final Book book = service.findById(id);
        service.takeBook(id);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save(argumentCaptor.capture());

        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void returnBook() {
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        final Long id = 123L;
        final Book book = service.findById(id);
        service.returnBook(id);
        Mockito.verify(bookRepository).save(book);
    }
}