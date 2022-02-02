package com.training.restLibrary.services;

import com.training.restLibrary.models.AccountEntity;

import java.util.List;

public interface UserService {
    AccountEntity register(AccountEntity account);

    List<AccountEntity> getAll();

    AccountEntity findByName(String name);

    AccountEntity findById(Long id);

    void delete(Long id);
}
