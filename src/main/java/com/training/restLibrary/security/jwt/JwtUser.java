package com.training.restLibrary.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Jwt user Entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
public class JwtUser implements UserDetails {

    private final Long id;
    private final String name;
    private final String password;
    private final boolean active;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * get password
     *
     * @return String password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * get name
     * @return String name
     */
    @Override
    public String getUsername() {
        return name;
    }

    /**
     * @return boolean active
     */
    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
