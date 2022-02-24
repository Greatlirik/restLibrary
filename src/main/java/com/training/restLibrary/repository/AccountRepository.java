package com.training.restLibrary.repository;


import com.training.restLibrary.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Account Repository
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    /**
     * Find account with given username
     *
     * @param username
     * @return Optional<Account>
     */
    Optional<Account> findByName(String username);
}
