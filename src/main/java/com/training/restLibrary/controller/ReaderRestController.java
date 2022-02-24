package com.training.restLibrary.controller;

import com.training.restLibrary.controller.dto.ReaderDto;
import com.training.restLibrary.controller.mapper.ReaderMapper;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.service.ActionManagerService;
import com.training.restLibrary.service.ReaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ReaderRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/readers")
@Tag(name = "Reader Controller", description = "Allows to perform CRUD operations on the reader and return book")
public class ReaderRestController {

    /**
     * Autowired field readerService
     */
    private final ReaderService readerService;

    /**
     * Autowired field managerService
     */
    private final ActionManagerService managerService;

    /**
     * Autowired field mapper
     */
    private final ReaderMapper mapper;

    /**
     * Find all readers
     *
     * @return List<ReaderDto>
     */
    @GetMapping
    public List<ReaderDto> findAllReaders() {
        List<Reader> readers = readerService.findAll();
        return readers.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    /**
     * Find reader by id
     *
     * @return List<ReaderDto>
     */
    @GetMapping("{id}")
    public ReaderDto getReader(final @PathVariable("id") Long readerId) {
        return mapper.toDto(readerService.findById(readerId));
    }

    /**
     * Return book from readers set to library
     *
     * @param readerId
     * @param bookId
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("{id}")
    public void returnBook(final @PathVariable("id") Long readerId, final @RequestParam(value = "bookId") Long bookId) {
        managerService.returnBook(bookId, readerId);
    }

    /**
     * Save reader
     *
     * @param reader
     * @return reader
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Reader saveReader(final @RequestBody @Valid Reader reader) {
        return readerService.save(reader);
    }

    /**
     * Delete reader
     *
     * @param readerId
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteReader(final @PathVariable("id") Long readerId) {
        readerService.deleteById(readerId);
    }

    /**
     * Update reader
     *
     * @param readerId
     * @param reader
     * @return reader
     */
    @PutMapping("{id}")
    public Reader updateReader(final @PathVariable("id") Long readerId, final @RequestBody @Valid Reader reader) {
        return readerService.update(reader, readerId);
    }
}
