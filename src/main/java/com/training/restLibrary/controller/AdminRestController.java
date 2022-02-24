package com.training.restLibrary.controller;

import com.training.restLibrary.controller.dto.AccountDto;
import com.training.restLibrary.model.Account;
import com.training.restLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminRESTController, available by admin endpoint
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    /**
     * Autowired field userService
     */
    private final UserService userService;

    /**
     * Find user with given id
     *
     * @param id
     * @return user and status
     */
    @GetMapping("/users/{id}")
    public AccountDto getUserById(@PathVariable("id") Long id) {
        Account account = userService.findById(id);
        AccountDto result = AccountDto.fromAccount(account);
        return result;
    }
}
