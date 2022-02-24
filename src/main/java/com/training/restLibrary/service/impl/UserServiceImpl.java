package com.training.restLibrary.service.impl;

import com.training.restLibrary.exception.ResourceNotFoundException;
import com.training.restLibrary.model.Account;
import com.training.restLibrary.model.Role;
import com.training.restLibrary.repository.AccountRepository;
import com.training.restLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Interface implementation CRUD and simple logic operations on User
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Account register(final Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setActive(true);
        account.setRoles(Collections.singletonList(Role.USER));

        Account registerAccount = accountRepository.save(account);

        log.info("In register - user: {} successfully registered", registerAccount);

        return registerAccount;
    }

    @Override
    public List<Account> getAll() {
        List<Account> result = (List<Account>) accountRepository.findAll();
        log.info("In getAll - {} users found", result.size());
        return result;
    }

    @Override
    public Account findByName(final String name) {
        Account account = accountRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("not found user with username " + name));
        log.info("In findByName - user: {} found by name: {}", account, name);
        return account;
    }

    @Override
    public Account findById(final Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found user with id " + id));
        log.info("In findById - user: {} found by id: {}", account, id);
        return account;
    }

    @Override
    public void delete(final Long id) {
        accountRepository.deleteById(id);
        log.info("In delete - user with id: {} successfully deleted", id);
    }
}
