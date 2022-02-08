package com.training.restLibrary.controller.rest;

import com.training.restLibrary.controller.dto.BookDto;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public List<Book> findAllBooks() {
        List<Book> books = bookService.findAll();
        return books;
    }

    @GetMapping("{id}")
    public Book getBook(final @PathVariable("id") Long bookId) {
        return bookService.findById(bookId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book saveBook(final @RequestBody @Valid Book book) {
        return bookService.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteBook(final @PathVariable("id") Long bookId) {
        bookService.deleteById(bookId);
    }

    @PutMapping("{id}")
    public Book updateReader(final @PathVariable("id") Long readerId, final @RequestBody @Valid Book book) {
        return bookService.update(book, readerId);
    }

    @GetMapping("/query/title")
    public ResponseEntity<List<Book>> findAllByTitleContainingIgnoreCase(final @RequestParam("title") String title){
        final List<Book> books = bookService.findAllByTitleContainingIgnoreCase(title);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

}
