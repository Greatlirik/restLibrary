package com.training.restLibrary.controller.dto;

import lombok.Data;

/**
 * Simple Dto for AuthenticationRequest
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Data
public class AuthenticationRequestDto {
    /**
     * Field username
     */
    private String username;

    /**
     * Field password
     */
    private String password;
}
