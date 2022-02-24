package com.training.restLibrary.service.impl;

import com.training.restLibrary.model.Book;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.model.Record;
import com.training.restLibrary.service.ActionManagerService;
import com.training.restLibrary.service.BookService;
import com.training.restLibrary.service.ReaderService;
import com.training.restLibrary.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Action manager service implementation
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ActionManagerServiceImpl implements ActionManagerService {

    private final BookService bookService;
    private final ReaderService readerService;
    private final RecordService recordService;

    @Override
    @Transactional
    public Book takeBook(final Long bookId, final Long readerId) {
        log.info("Start transactional-method takeBook");
        final Book book = bookService.takeBook(bookId);
        readerService.takeBook(readerId, book);
        final Record record = recordService.takeBook(book, readerService.findById(readerId));
        recordService.save(record);
        log.info("Book with id: {} successfully took by reader with id: {}", bookId, readerId);
        return book;
    }

    @Override
    @Transactional
    public void returnBook(final Long bookId, final Long readerId) {
        log.info("Start transactional-method returnBook");
        final Book book = bookService.returnBook(bookId);
        final Reader reader = readerService.returnBook(readerId, book);
        final Record record = recordService.returnBook(book, readerService.findById(readerId));
        recordService.save(record);
        if (record.getRealReturnDate().isAfter(record.getReturnDate())) {
            reader.setRating(reader.getRating() - 20);
        }
        log.info("Book with id: {} successfully returned by reader with id: {}", bookId, readerId);
    }
}
