package com.training.restLibrary.security.jwt;

import com.training.restLibrary.models.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long validityInMilliseconds;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    public String createToken(String name, List<Role> roles) {
        Claims claims = Jwts.claims().setSubject(name);
        claims.put("roles", getRoleNames(roles));
        return null;
    }

    public Authentication getAuthentication(String token) {
        return null;
    }

    public String getUserName(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return true;
    }

    private List<String> getRoleNames(List<Role> userRoles) {
        List<String> result = new ArrayList<>();
        userRoles.forEach(role ->
                result.add(role.toString()));
        return result;
    }
}
