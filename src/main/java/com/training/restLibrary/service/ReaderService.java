package com.training.restLibrary.service;

import com.training.restLibrary.model.Reader;

import java.util.List;

public interface ReaderService {
    List<Reader> findAll();

    Reader save(Reader reader);

    void deleteById(Long id);

    Reader findById(Long id);

    Reader update(Reader reader, Long id);
}
