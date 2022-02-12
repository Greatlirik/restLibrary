package com.training.restLibrary.service.impl;

import com.training.restLibrary.exception.ResourceNotFoundException;
import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import com.training.restLibrary.repository.BookRepository;
import com.training.restLibrary.repository.ReaderRepository;
import com.training.restLibrary.repository.RecordRepository;
import com.training.restLibrary.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    @Override
    public Page<Record> findAll(Optional<Integer> page) {
        final Page<Record> result = recordRepository.findAll(PageRequest.of(page.orElse(0), 5));
        log.info("In getAll - {} records found", result.getTotalElements());
        return result;
    }

    @Override
    public Record save(final Record record) {
        recordRepository.save(record);
        log.info("In save - record with id: {} successfully saved", record.getId());
        return record;
    }

    @Override
    public void deleteById(final Long id) {
        recordRepository.deleteById(id);
        log.info("In delete - record with id: {} successfully deleted", id);
    }

    @Override
    public Record findById(final Long id) {
        final Record record = recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found record with id" + id));
        log.info("In findById - record: {} found by id: {}", record, id);
        return record;
    }

    @Override
    public Record update(final Record record, final Long id) {
        recordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found record with id" + id));
        record.setId(id);
        recordRepository.save(record);
        log.info("In update - reader with id: {} successfully updated", id);
        return record;
    }

    @Override
    public Page<Record> findAllByReader(Long readerId, Optional<Integer> page) {
        final Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("not found reader with id" + readerId));
        final Page<Record> result = recordRepository.findAllByReader(reader, PageRequest.of(page.orElse(0), 5));
        log.info("In findAllByReader - {} records found", result.getTotalElements());
        return result;
    }

    @Override
    public Page<Record> findAllByBook(Long bookId, Optional<Integer> page) {
        final Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("not found book with id" + bookId));
        final Page<Record> result = recordRepository.findAllByBook(book, PageRequest.of(page.orElse(0), 5));
        log.info("In findAllByBook - {} records found", result.getTotalElements());
        return result;
    }

    @Override
    public Record findByBookAndReader(final Reader reader, final Book book) {
        final Record record = recordRepository.findByReaderAndBookAndRealReturnDateIsNull(reader, book).orElseThrow(() -> new ResourceNotFoundException("test2"));
        log.info("In findByBookAndReader - record: {} found by book: {} and reader: {}", record, book, reader);
        return record;
    }

    @Override
    public Record takeBook(final Book book, final Reader reader) {
        Record record = new Record()
                .setBook(book)
                .setReader(reader)
                .setReceiptDate(LocalDate.now())
                .setReturnDate(LocalDate.now().plusDays(7))
                .setRealReturnDate(null);
        return record;
    }

    @Override
    public Record returnBook(final Book book, final Reader reader) {
        final Record previousRecord = findByBookAndReader(reader, book);
        final Record record = previousRecord;
        record.setRealReturnDate(LocalDate.now());
        return record;
    }

}
