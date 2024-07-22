package com.iambartz.recruitmenttask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    ErrorDto handleUsernameNotFound(UsernameNotFoundException exception) {
        return ErrorDto.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
    }
}
