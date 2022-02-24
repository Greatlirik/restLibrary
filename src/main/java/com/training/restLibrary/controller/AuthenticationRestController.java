package com.training.restLibrary.controller;

import com.training.restLibrary.controller.dto.AuthenticationRequestDto;
import com.training.restLibrary.model.Account;
import com.training.restLibrary.security.jwt.JwtTokenProvider;
import com.training.restLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {

    /**
     * Autowired field authenticationManager
     */
    private final AuthenticationManager authenticationManager;

    /**
     * Autowired field jwtTokenProvider
     */
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Autowired field userService
     */
    private final UserService userService;

    /**
     * Login
     *
     * @param authenticationRequestDto
     * @return
     */
    @PostMapping("/login")
    public Map<Object, Object> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        try {
            String username = authenticationRequestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    authenticationRequestDto.getPassword()));
            Account account = userService.findByName(username);

            if (account == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, account.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return response;

        } catch (AuthenticationException exception) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
