package com.training.restLibrary.repository;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RecordRepository extends PagingAndSortingRepository<Record, Long> {
    List<Record> findAllByReader(Reader reader);

    List<Record> findAllByBook(Book book);
}
