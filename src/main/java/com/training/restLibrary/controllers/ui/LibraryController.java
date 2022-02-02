package com.training.restLibrary.controllers.ui;


import com.training.restLibrary.models.BookEntity;
import com.training.restLibrary.repositories.AccountRepository;
import com.training.restLibrary.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LibraryController {
    private final BookRepository bookRepository;
    private final AccountRepository accountRepository;

    @GetMapping("/library")
    public ModelAndView page() {
        final Map<String, Object> model = Map.of(
                "books", bookRepository.findAll()
        );
        return new ModelAndView("library", model);
    }

    @GetMapping("/search")
    public ModelAndView pageSearch(@RequestParam(name = "q", required = false) String query) {
        final List<BookEntity> books = Optional.ofNullable(query)
                .map(bookRepository::findAllByTitleContainingIgnoreCase)
                .orElseGet(Collections::emptyList);
        final Map<String, Object> model = Map.of(
                "books", books
        );
        return new ModelAndView("search", model);
    }
}