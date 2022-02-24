package com.training.restLibrary.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Error message
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public class ErrorMessage {

    /**
     * Field timestamp
     */
    private Date timestamp;

    /**
     * Field message
     */
    private String message;

    /**
     * Field description
     */
    private String description;
}
