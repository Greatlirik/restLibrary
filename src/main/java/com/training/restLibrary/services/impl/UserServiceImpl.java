package com.training.restLibrary.services.impl;

import com.training.restLibrary.models.AccountEntity;
import com.training.restLibrary.models.Role;
import com.training.restLibrary.repositories.AccountRepository;
import com.training.restLibrary.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AccountEntity register(final AccountEntity account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setActive(true);
        account.setRoles(Collections.singleton(Role.USER));

        AccountEntity registerAccount = accountRepository.save(account);

        log.info("In register - user: {} successfully registered", registerAccount);

        return registerAccount;
    }

    @Override
    public List<AccountEntity> getAll() {
        List<AccountEntity> result = (List<AccountEntity>) accountRepository.findAll();
        log.info("In getAll - {} users found", result.size());
        return result;
    }

    @Override
    public AccountEntity findByName(final String name) {
        AccountEntity account = accountRepository.findByName(name).orElseThrow();
        log.info("In findByName - user: {} found by name: {}", account, name);
        return account;
    }

    @Override
    public AccountEntity findById(final Long id) {
        AccountEntity account = accountRepository.findById(id).orElseThrow();
        log.info("In findById - user: {} found by id: {}", account, id);
        return account;
    }

    @Override
    public void delete(final Long id) {
        accountRepository.deleteById(id);
        log.info("In delete - user with id: {} successfully deleted", id);
    }
}
