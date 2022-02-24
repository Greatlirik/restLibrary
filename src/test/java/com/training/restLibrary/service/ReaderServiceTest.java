package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.repository.ReaderRepository;
import com.training.restLibrary.service.impl.ReaderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderServiceImpl service;

    final Reader reader = new Reader(11L, "Usual", "tester", "t-t@mail.ru"
            , 143L, 2345678, 70, LocalDate.now(), new HashSet<>());

    final Reader reader2 = new Reader(18L, "Second", "tester", "t2-t@mail.ru"
            , 148L, 2345673, 90, LocalDate.now(), null);

    List<Reader> result = Arrays.asList(reader, reader2);

    @Test
    void findAll() {
        Mockito.when(readerRepository.findAll()).thenReturn(result);
        service.findAll();
        Mockito.verify(readerRepository).findAll();
    }

    @Test
    void save() {
        service.save(reader);
        Mockito.verify(readerRepository).save(reader);
    }

    @Test
    void deleteById() {
        final Long id = 11L;
        Mockito.when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        service.deleteById(id);
        Mockito.verify(readerRepository).deleteById(id);
    }

    @Test
    void findById() {
        Mockito.when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        final Long id = 11L;
        service.findById(id);
        Mockito.verify(readerRepository).findById(id);
    }

    @Test
    void update() {
        Mockito.when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        Reader reader2 = new Reader(23L, "Second3", "tester3", "t23-t@mail.ru"
                , 148L, 2345673, 90, LocalDate.now(), null);
        service.update(reader2, 11L);
        Mockito.verify(readerRepository).save(reader2);
    }

    @Test
    void takeBook() {
        final Long id = 11L;

        Book book = new Book(123L, "title", "genre", 2000,
                "description", 10, true, null);

        Mockito.when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        service.takeBook(id, book);
        Mockito.verify(readerRepository).save(reader);
    }

    @Test
    void returnBook() {
    }
}