package com.training.restLibrary.controllers.rest;

import com.training.restLibrary.models.BookEntity;
import com.training.restLibrary.models.dtos.BookDto;
import com.training.restLibrary.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {

    private final BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<BookEntity>> findAllBooks() {
        List<BookEntity> books = (List<BookEntity>) bookRepository.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookEntity> getBook(final @PathVariable("id") Long bookId) {
        return ResponseEntity.of(bookRepository.findById(bookId));
    }

    @PostMapping("")
    public ResponseEntity<BookEntity> saveBook(final @RequestBody BookDto bookDto) {
        final BookEntity bookEntity = bookRepository.save(bookDto.toBookEntity());
        return new ResponseEntity<>(bookEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<BookEntity> deleteBook(final @PathVariable("id") Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<BookEntity> updateBook(final @PathVariable("id") Long bookId, final @Valid @RequestBody BookDto bookDto) {
        BookEntity checkBookEntity = bookRepository.findById(bookId).orElseThrow();
        final BookEntity bookEntity = bookDto.toBookEntity();
        bookEntity.setId(bookId);
        bookRepository.save(bookEntity);
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);

    }
}
