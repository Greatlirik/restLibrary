package com.training.restLibrary.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ExceptionHandler
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Throws a error message when catching a ResourceNotFoundException
     *
     * @param exception
     * @param webRequest
     * @return error message
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(final ResourceNotFoundException exception
            , final WebRequest webRequest) {
        final ErrorMessage message = new ErrorMessage(
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        log.warn("Exception resourceNotFound " + LocalDateTime.now());
        return message;
    }

    /**
     * Throws a error message when catching a GlobalExceptionHandler
     *
     * @param ex
     * @param request
     * @return error message
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(final Exception ex, final WebRequest request) {
        final ErrorMessage message = new ErrorMessage(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        log.warn("Exception globalException " + LocalDateTime.now());
        return message;
    }
}
