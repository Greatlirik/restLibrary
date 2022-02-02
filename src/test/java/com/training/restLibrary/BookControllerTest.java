package com.training.restLibrary;

import com.training.restLibrary.controllers.rest.BookRestController;
import com.training.restLibrary.models.dtos.BookDto;
import com.training.restLibrary.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookRestController bookRestController;

    @Test
    void getAllBooks() {
        bookRestController.findAllBooks();
        Mockito.verify(bookRepository).findAll();
    }

    @Test
    void getBook() {
        long id = 0L;
        bookRestController.getBook(id);
        Mockito.verify(bookRepository).findById(id);

    }

    @Test
    void saveEmployee() {
        BookDto bookDto = new BookDto();
        bookRestController.saveBook(bookDto);
        Mockito.verify(bookRepository).save(bookDto.toBookEntity());
    }
    
}
