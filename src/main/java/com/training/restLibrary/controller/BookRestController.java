package com.training.restLibrary.controller;

import com.training.restLibrary.controller.dto.BookDto;
import com.training.restLibrary.controller.mapper.BookMapper;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.service.ActionManagerService;
import com.training.restLibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * BookRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "Allows to perform CRUD operations on the book and search by parameters")
public class BookRestController {

    /**
     * Autowired field bookService
     */
    private final BookService bookService;

    /**
     * Autowired field managerService
     */
    private final ActionManagerService managerService;

    /**
     * Autowired field bookMapper
     */
    private final BookMapper bookMapper;

    /**
     * Find all books
     *
     * @param page
     * @return List<BookDto>
     */
    @Operation(
            summary = "Find all books"
    )
    @GetMapping
    public List<BookDto> findAllBooks(
            @RequestParam @Parameter(description = "Page number for pagination") Optional<Integer> page) {
        Page<Book> books = bookService.findAll(page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Find book with given id
     *
     * @param bookId
     * @return bookDto
     */
    @GetMapping("{id}")
    public BookDto getBook(final @PathVariable("id") Long bookId) {
        return bookMapper.toDto(bookService.findById(bookId));
    }

    /**
     * Allows reader takes book
     *
     * @param bookId
     * @param readerId
     * @return
     */
    @PostMapping("{id}")
    public Book takeBook(final @PathVariable("id") Long bookId, final @RequestParam(value = "readerId") Long readerId) {
        return managerService.takeBook(bookId, readerId);
    }

    /**
     * Save book
     *
     * @param bookDto
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book saveBook(final @RequestBody @Valid BookDto bookDto) {
        return bookService.save(bookMapper.toEntity(bookDto));
    }

    /**
     * Delete book
     *
     * @param bookId
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteBook(final @PathVariable("id") Long bookId) {
        bookService.deleteById(bookId);
    }

    /**
     * Update Book
     *
     * @param readerId
     * @param bookDto
     * @return book
     */
    @PutMapping("{id}")
    public Book updateBook(final @PathVariable("id") Long readerId, final @RequestBody @Valid BookDto bookDto) {
        return bookService.update(bookMapper.toEntity(bookDto), readerId);
    }

    /**
     * Search all books with given title
     *
     * @param page
     * @return List<BookDto>
     */
    @GetMapping("/search/title")
    public List<BookDto> findAllByTitle(
            final @RequestParam("title") String title,
            final @RequestParam @Parameter(description = "Page number for pagination") Optional<Integer> page) {
        final Page<Book> books = bookService.findAllByTitleContainingIgnoreCase(title, page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Search all books with given genre
     *
     * @param page
     * @return List<BookDto>
     */
    @GetMapping("/search/genre")
    public List<BookDto> findAllByGenre(
            final @RequestParam("genre") String genre,
            final @RequestParam @Parameter(description = "Page number for pagination") Optional<Integer> page) {
        final Page<Book> books = bookService.findAllByGenreIgnoreCase(genre, page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Search all books with given author
     *
     * @param page
     * @return List<BookDto>
     */
    @GetMapping("/search/author")
    public List<BookDto> findAllByAuthor(
            final @RequestParam("author") String author,
            final @RequestParam @Parameter(description = "Page number for pagination") Optional<Integer> page) {
        final Page<Book> books = bookService.findAllByAuthors(author, page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Search all books with given availability
     *
     * @param page
     * @return List<BookDto>
     */
    @GetMapping("/search/availability")
    public List<BookDto> findAllByAvailability(
            final @RequestParam("available") boolean available,
            final @RequestParam @Parameter(description = "Page number for pagination") Optional<Integer> page) {
        final Page<Book> books = bookService.findAllByAvailability(available, page);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

}
