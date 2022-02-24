package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;

/**
 * Manager Service that includes work with other services
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface ActionManagerService {
    /**
     * Save book by the reader
     *
     * @param bookId
     * @param readerId
     * @return book
     */
    Book takeBook(final Long bookId, final Long readerId);

    /**
     * Return book from reader
     *
     * @param bookId
     * @param readerId
     */
    void returnBook(final Long bookId, final Long readerId);
}
