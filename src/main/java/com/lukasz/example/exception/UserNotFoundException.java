package com.lukasz.example.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("User with username [%s] was not found".formatted(username));
    }

}
