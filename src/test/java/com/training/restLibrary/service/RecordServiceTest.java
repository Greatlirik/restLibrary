package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.repository.ReaderRepository;
import com.training.restLibrary.repository.RecordRepository;
import com.training.restLibrary.service.impl.ReaderServiceImpl;
import com.training.restLibrary.service.impl.RecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecordServiceTest {

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private RecordServiceImpl service;

    Book book = new Book(123L, "title", "genre", 2000,
            "description", 10, true, null);

    Reader reader = new Reader(11L, "Usual", "tester", "t-t@mail.ru"
            , 143L, 2345678, 70, LocalDate.now(), new HashSet<>());

    Record record = new Record(
            151L, book, reader, LocalDate.now(), LocalDate.now(), LocalDate.now()
    );

    Record record2 = new Record(
            157L, book, reader, LocalDate.now(), LocalDate.now(), LocalDate.now()
    );

    List<Record> records = Arrays.asList(record, record2);
    Page<Record> result = new PageImpl<>(records, PageRequest.of(0, 5), records.size());

    @Test
    void findAll() {
        Mockito.when(recordRepository.findAll(PageRequest.of(0, 5))).thenReturn(result);
        service.findAll(Optional.of(0), null, null);
        Mockito.verify(recordRepository).findAll(PageRequest.of(0, 5));
    }

    @Test
    void findAllByBook() {
        Mockito.when(recordRepository.findAllByBook(book, PageRequest.of(0, 5))).thenReturn(result);
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        service.findAll(Optional.of(0), 123L, null);
        Mockito.verify(recordRepository).findAllByBook(book, PageRequest.of(0, 5));
    }

    @Test
    void findAllByReader() {
        Mockito.when(recordRepository.findAllByReader(reader, PageRequest.of(0, 5))).thenReturn(result);
        Mockito.when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        service.findAll(Optional.of(0), null, 11L);
        Mockito.verify(recordRepository).findAllByReader(reader, PageRequest.of(0, 5));
    }

    @Test
    void save() {
        service.save(record);
        Mockito.verify(recordRepository).save(record);
    }

    @Test
    void deleteById() {
        final Long id = 151L;
        Mockito.when(recordRepository.findById(record.getId())).thenReturn(Optional.of(record));
        service.deleteById(id);
        Mockito.verify(recordRepository).deleteById(id);
    }

    @Test
    void findById() {
        Mockito.when(recordRepository.findById(record.getId())).thenReturn(Optional.of(record));
        final Long id = 151L;
        service.findById(id);
        Mockito.verify(recordRepository).findById(id);
    }

    @Test
    void update() {
        Mockito.when(recordRepository.findById(record.getId())).thenReturn(Optional.of(record));
        Record record2 = new Record(
                157L, book, reader, LocalDate.now(), LocalDate.now(), LocalDate.now()
        );
        service.update(record2, 151L);
        Mockito.verify(recordRepository).save(record2);
    }

    @Test
    void takeBook() {
        service.takeBook(book, reader);
        Mockito.verify(recordRepository).save(new Record(null, book, reader, LocalDate.now(), LocalDate.now().plusDays(7), null));
    }

    @Test
    void returnBook() {
        Mockito.when(recordRepository.findByReaderAndBookAndRealReturnDateIsNull(reader, book))
                .thenReturn(Optional.ofNullable(record));
        final Record record = service.returnBook(book, reader);
        Mockito.verify(recordRepository).save(record);
    }

    @Test
    void findByBookAndReader() {
        Mockito.when(recordRepository.findByReaderAndBookAndRealReturnDateIsNull(reader, book))
                .thenReturn(Optional.ofNullable(record));

        service.findByBookAndReader(reader, book);
        Mockito.verify(recordRepository).findByReaderAndBookAndRealReturnDateIsNull(reader, book);
    }
}