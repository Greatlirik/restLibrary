package com.training.restLibrary.repositories;


import com.training.restLibrary.models.AuthorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<AuthorEntity, Long> {
}
