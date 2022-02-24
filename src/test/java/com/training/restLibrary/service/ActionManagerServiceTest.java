package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import com.training.restLibrary.service.impl.ActionManagerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
class ActionManagerServiceTest {

    @Mock
    private ReaderService readerService;

    @Mock
    private BookService bookService;

    @Mock
    private RecordService recordService;

    @InjectMocks
    private ActionManagerServiceImpl service;

    Book book = new Book(123L, "title", "genre", 2000,
            "description", 10, true, null);

    Reader reader = new Reader(11L, "Usual", "tester", "t-t@mail.ru"
            , 143L, 2345678, 70, LocalDate.now(), new HashSet<>());

    Record record = new Record(
            151L, book, reader, LocalDate.now(), LocalDate.now(), LocalDate.now()
    );

    @Test
    void takeBook() {
        Mockito.when(readerService.findById(reader.getId())).thenReturn(reader);
        Mockito.when(bookService.takeBook(book.getId())).thenReturn(book);
        Mockito.when(recordService.takeBook(book, reader)).thenReturn(record);
        Mockito.when(readerService.takeBook(reader.getId(), book)).thenReturn(book);

        service.takeBook(this.book.getId(), reader.getId());

        Mockito.verify(bookService).takeBook(this.book.getId());
        Mockito.verify(recordService).takeBook(this.book, reader);
        Mockito.verify(recordService).save(record);
        Mockito.verify(readerService).takeBook(reader.getId(), this.book);
    }

    @Test
    void returnBook() {
        Mockito.when(readerService.findById(reader.getId())).thenReturn(reader);
        Mockito.when(bookService.returnBook(book.getId())).thenReturn(book);
        Mockito.when(recordService.returnBook(book, reader)).thenReturn(record);
        Mockito.when(readerService.returnBook(reader.getId(), book)).thenReturn(reader);

        service.returnBook(book.getId(), reader.getId());

        Mockito.verify(bookService).returnBook(book.getId());
        Mockito.verify(recordService).save(record);
        Mockito.verify(recordService).returnBook(book, reader);
        Mockito.verify(readerService).returnBook(reader.getId(), book);
    }
}