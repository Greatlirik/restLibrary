package com.training.restLibrary.controllers.rest;

import com.training.restLibrary.models.AccountEntity;
import com.training.restLibrary.models.BookEntity;
import com.training.restLibrary.repositories.AccountRepository;
import com.training.restLibrary.services.DefaultUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountRestController {

    private final AccountRepository accountRepository;

//    @GetMapping("/account")
//    public Set<BookEntity> getAllBooks() {
//        final Set<BookEntity> books = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
//                .map(Authentication::getPrincipal)
//                .filter(auth -> auth instanceof DefaultUserDetailsService.SimpleUserDetails)
//                .map(auth -> (DefaultUserDetailsService.SimpleUserDetails) auth)
//                .map(DefaultUserDetailsService.SimpleUserDetails::getAccount)
//                .map(AccountEntity::getBooks)
//                .orElseThrow();
//        return books;
//    }

    @GetMapping("")
    public ResponseEntity<List<AccountEntity>> findAllAccounts() {
        List<AccountEntity> accounts = (List<AccountEntity>) accountRepository.findAll();

        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
