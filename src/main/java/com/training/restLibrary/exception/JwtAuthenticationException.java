package com.training.restLibrary.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * JwtAuthenticationException
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public class JwtAuthenticationException extends AuthenticationException {
    /**
     * Constructor with 2 parameters (String msg, Throwable cause)
     */
    public JwtAuthenticationException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    /**
     * * Constructor with 1 parameters (String msg)
     */
    public JwtAuthenticationException(final String msg) {
        super(msg);
    }
}
