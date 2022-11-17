package com.example.practice.logic.exceptions;

public class ButtonsExceptions extends Exception {
    private String text_exception;

    public ButtonsExceptions(String text_exception) {
        this.text_exception = text_exception;
    }

    public String getString() {
        return this.text_exception;
    }
}
