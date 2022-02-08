package com.training.restLibrary.repository;

import com.training.restLibrary.model.Reader;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReaderRepository extends PagingAndSortingRepository<Reader, Long> {
}
