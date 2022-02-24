package com.training.restLibrary.service.impl;

import com.training.restLibrary.model.Account;
import com.training.restLibrary.security.jwt.JwtUser;
import com.training.restLibrary.security.jwt.JwtUserFactory;
import com.training.restLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JwtUserDetailsService
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Primary
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        Account account = userService.findByName(name);

        if (account == null) {
            throw new UsernameNotFoundException("User with username:" + name + "not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(account);

        log.info("In loadByUsername - user with name : {} successfully loaded", name);
        return jwtUser;
    }
}
