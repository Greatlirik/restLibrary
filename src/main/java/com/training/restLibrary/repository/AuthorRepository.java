package com.training.restLibrary.repository;


import com.training.restLibrary.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Author Repository
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    /**
     * find all authors with given name ignoring case
     *
     * @param lastName
     * @return Optional<Author>
     */
    Optional<Author> findByLastNameIgnoringCase(String lastName);
}
