package com.training.restLibrary.service.impl;

import com.training.restLibrary.exception.ResourceNotFoundException;
import com.training.restLibrary.model.Reader;
import com.training.restLibrary.repository.ReaderRepository;
import com.training.restLibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    @Override
    public List<Reader> findAll() {
        final List<Reader> result = (List<Reader>) readerRepository.findAll();
        log.info("In getAll - {} readers found", result.size());
        return result;
    }

    @Override
    public Reader save(final Reader reader) {
        readerRepository.save(reader);
        log.info("In save - reader with id: {} successfully saved", reader.getId());
        return reader;
    }

    @Override
    public void deleteById(final Long id) {
        readerRepository.deleteById(id);
        log.info("In delete - reader with id: {} successfully deleted", id);
    }

    @Override
    public Reader findById(final Long id) {
        final Reader reader = readerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found reader with id" + id));
        log.info("In findById - reader: {} found by id: {}", reader, id);
        return reader;
    }

    @Override
    public Reader update(final Reader reader, final Long id) {
        readerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found reader with id" + id));
        reader.setId(id);
        readerRepository.save(reader);
        log.info("In update - reader with id: {} successfully updated", id);
        return reader;
    }
}
