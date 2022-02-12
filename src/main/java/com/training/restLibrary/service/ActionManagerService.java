package com.training.restLibrary.service;

import com.training.restLibrary.model.Book;

public interface ActionManagerService {
    Book takeBook(final Long bookId, final Long readerId);

    void returnBook(final Long bookId, final Long readerId);
}
