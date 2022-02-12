package com.training.restLibrary.controller.rest;

import com.training.restLibrary.model.Reader;
import com.training.restLibrary.service.ActionManagerService;
import com.training.restLibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/readers")
public class ReaderRestController {

    private final ReaderService readerService;
    private final ActionManagerService managerService;

    @GetMapping
    public List<Reader> findAllReaders() {
        List<Reader> readers = readerService.findAll();
        return readers;
    }

    @GetMapping("{id}")
    public Reader getReader(final @PathVariable("id") Long readerId) {
        return readerService.findById(readerId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("{id}")
    public void returnBook(final @PathVariable("id") Long readerId, final @RequestParam(value = "bookId") Long bookId) {
        managerService.returnBook(bookId, readerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Reader saveReader(final @RequestBody @Valid Reader reader) {
        return readerService.save(reader);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteReader(final @PathVariable("id") Long readerId) {
        readerService.deleteById(readerId);
    }

    @PutMapping("{id}")
    public Reader updateReader(final @PathVariable("id") Long readerId, final @RequestBody @Valid Reader reader) {
        return readerService.update(reader, readerId);
    }
}
