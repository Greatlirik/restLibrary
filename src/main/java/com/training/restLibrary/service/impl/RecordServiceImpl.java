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
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Record> findAll() {
        final List<Record> result = (List<Record>) recordRepository.findAll();
        log.info("In getAll - {} records found", result.size());
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
        final Record record = recordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found record with id" + id));
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
    public List<Record> findAllByReader(Long readerId) {
        final Reader reader = readerRepository.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("not found reader with id" + readerId));
        final List<Record> result = recordRepository.findAllByReader(reader);
        log.info("In findAllByReader - {} records found", result.size());
        return result;
    }

    @Override
    public List<Record> findAllByBook(Long bookId) {
        final Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("not found book with id" + bookId));
        final List<Record> result = recordRepository.findAllByBook(book);
        log.info("In findAllByBook - {} records found", result.size());
        return result;
    }
}
