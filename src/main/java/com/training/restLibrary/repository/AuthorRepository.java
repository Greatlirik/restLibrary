package com.training.restLibrary.repository;


import com.training.restLibrary.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
