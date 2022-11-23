package com.example.practice.logic.exceptions;

public class UserException extends Throwable {
    private String error;

    public UserException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
