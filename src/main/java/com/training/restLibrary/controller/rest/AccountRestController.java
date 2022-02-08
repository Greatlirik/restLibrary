package com.training.restLibrary.controller.rest;

import com.training.restLibrary.model.Account;
import com.training.restLibrary.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountRestController {

    private final AccountRepository accountRepository;

    @GetMapping("")
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();

        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
