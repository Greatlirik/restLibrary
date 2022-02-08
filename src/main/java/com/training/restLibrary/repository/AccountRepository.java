package com.training.restLibrary.repository;


import com.training.restLibrary.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account,Long> {
    Optional<Account> findByName(String username);
}
