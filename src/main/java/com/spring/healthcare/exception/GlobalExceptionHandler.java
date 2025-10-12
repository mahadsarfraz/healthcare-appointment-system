package com.spring.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // 422
    public ErrorResponse handleDataValidationException(DataValidationException ex) {
        return new ErrorResponse(ex.getMessage(), ex.getCode(), "DataValidationException");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    public ErrorResponse handleBadRequestException(BadRequestException ex) {
        return new ErrorResponse(ex.getMessage(), 400, "BadRequestException");
    }

    public static class ErrorResponse {
        private String message;
        private int code;
        private String exceptionType;

        public ErrorResponse(String message, int code, String exceptionType) {
            this.message = message;
            this.code = code;
            this.exceptionType = exceptionType;
        }

        public String getMessage() {
            return message;
        }

        public int getCode() {
            return code;
        }

        public String getExceptionType() {
            return exceptionType;
        }
    }
}
