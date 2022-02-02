package com.training.restLibrary.repositories;


import com.training.restLibrary.models.BookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long> {
    List<BookEntity> findAllByTitleContainingIgnoreCase(String title);
}
