package com.training.restLibrary.controller.rest;

import com.training.restLibrary.controller.dto.BookDto;
import com.training.restLibrary.controller.mapper.BookMapper;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.service.ActionManagerService;
import com.training.restLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;
    private final ActionManagerService managerService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> findAllBooks(@RequestParam Optional<Integer> page) {
        Page<Book> books = bookService.findAll(page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public BookDto getBook(final @PathVariable("id") Long bookId) {
        return bookMapper.toDto(bookService.findById(bookId));
    }

    @PostMapping("{id}")
    public Book takeBook(final @PathVariable("id") Long bookId, final @RequestParam(value = "readerId") Long readerId) {
        return managerService.takeBook(bookId, readerId);
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

//    @GetMapping("/query/title")
//    public ResponseEntity<List<Book>> findAllByTitleContainingIgnoreCase(final @RequestParam("title") String title){
//        final List<Book> books = bookService.findAllByTitleContainingIgnoreCase(title);
//        if (books.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(books,HttpStatus.OK);
//    }

}
