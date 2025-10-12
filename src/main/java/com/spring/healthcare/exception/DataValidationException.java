package com.spring.healthcare.exception;

public class DataValidationException extends RuntimeException {
    private final int code = 422;

    public DataValidationException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
