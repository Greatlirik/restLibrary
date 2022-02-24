package com.training.restLibrary.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.training.restLibrary.model.Account;
import lombok.Data;

/**
 * DTO for Account
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    private Long id;
    private String username;

    /**
     * transfer DTO to Account
     *
     * @return account
     */
    public Account toAccount() {
        Account account = new Account();
        account.setId(id);
        account.setName(username);
        return account;
    }

    /**
     * transfer Account to DTO
     *
     * @param account
     * @return accountDto
     */
    public static AccountDto fromAccount(final Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setUsername(account.getName());
        return accountDto;
    }
}
