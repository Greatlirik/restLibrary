package com.training.restLibrary.security.jwt;

import com.training.restLibrary.models.AccountEntity;
import com.training.restLibrary.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(AccountEntity account) {
        return new JwtUser(
                account.getId(),
                account.getName(),
                account.getPassword(),
                account.isActive(),
                mapToGrantedAuthorities(new ArrayList<>(account.getRoles()))
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles){
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
