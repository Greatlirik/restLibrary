package com.training.restLibrary.controller;

import com.training.restLibrary.model.Account;
import com.training.restLibrary.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountRestController {

    /**
     * Autowired field accountRepository
     */
    private final AccountRepository accountRepository;

    /**
     * Find all accounts
     *
     * @return all accounts and status
     */
    @GetMapping
    public List<Account> findAllAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accounts;
    }

}
