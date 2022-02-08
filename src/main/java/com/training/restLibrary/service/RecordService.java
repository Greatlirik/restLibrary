package com.training.restLibrary.service;

import com.training.restLibrary.model.Record;

import java.util.List;

public interface RecordService {
    List<Record> findAll();

    Record save(Record record);

    void deleteById(Long id);

    Record findById(Long id);

    Record update(Record record, Long id);

    List<Record> findAllByReader(Long readerId);

    List<Record> findAllByBook(Long bookId);
}
