package com.training.restLibrary.service;

import com.training.restLibrary.model.Account;

import java.util.List;

/**
 * CRUD and simple logic operations on User
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface UserService {

    /**
     * set account password, roles and save it in repository
     *
     * @param account
     * @return account
     */
    Account register(Account account);

    /**
     * Get all accounts
     *
     * @return list with all accounts
     */
    List<Account> getAll();

    /**
     * find account with given name
     *
     * @param name
     * @return account
     */
    Account findByName(String name);

    /**
     * find account with given id
     *
     * @param id
     * @return account
     */
    Account findById(Long id);

    /**
     * delete account with given name
     *
     * @param id
     * @return account
     */
    void delete(Long id);
}
