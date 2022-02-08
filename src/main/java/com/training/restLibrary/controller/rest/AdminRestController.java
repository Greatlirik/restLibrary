package com.training.restLibrary.controller.rest;

import com.training.restLibrary.controller.dto.AccountDto;
import com.training.restLibrary.model.Account;
import com.training.restLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<AccountDto> getUserById(@PathVariable("id") Long id){
        Account account = userService.findById(id);

        if(account == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AccountDto result = AccountDto.fromAccount(account);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
