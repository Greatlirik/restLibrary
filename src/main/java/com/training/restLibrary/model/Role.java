package com.training.restLibrary.model;

import lombok.Getter;
import lombok.ToString;

/**
 * Enum Role
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Getter
@ToString
public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    /**
     * field name
     */
    private final String name;

    /**
     * Constructor with parameter name
     *
     * @param name
     */
    Role(String name) {
        this.name = name;
    }

}
