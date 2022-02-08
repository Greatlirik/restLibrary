package com.training.restLibrary.service;

import com.training.restLibrary.model.Account;

import java.util.List;

public interface UserService {
    Account register(Account account);

    List<Account> getAll();

    Account findByName(String name);

    Account findById(Long id);

    void delete(Long id);
}
