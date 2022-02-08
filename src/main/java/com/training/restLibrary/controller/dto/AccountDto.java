package com.training.restLibrary.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.training.restLibrary.model.Account;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    private Long id;
    private String username;

    public Account toAccount() {
        Account account = new Account();
        account.setId(id);
        account.setName(username);
        return account;
    }

    public static AccountDto fromAccount(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setUsername(account.getName());
        return accountDto;
    }
}
