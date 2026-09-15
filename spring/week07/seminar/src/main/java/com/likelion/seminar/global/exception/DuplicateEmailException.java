package com.likelion.seminar.global.exception;

public class DuplicateEmailException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Email already exists";
    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException() {
        super(DEFAULT_MESSAGE);
    }
}


