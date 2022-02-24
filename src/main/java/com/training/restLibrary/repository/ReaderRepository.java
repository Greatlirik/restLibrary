package com.training.restLibrary.repository;

import com.training.restLibrary.model.Reader;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Reader Repository
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface ReaderRepository extends PagingAndSortingRepository<Reader, Long> {
}
