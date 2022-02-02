package com.training.restLibrary.repositories;


import com.training.restLibrary.models.AccountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<AccountEntity,Long> {
    Optional<AccountEntity> findByName(String username);
}
