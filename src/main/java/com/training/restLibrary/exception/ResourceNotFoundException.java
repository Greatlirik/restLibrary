package com.training.restLibrary.exception;

/**
 * Custom ResourceNotFoundException
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with parameter message
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
