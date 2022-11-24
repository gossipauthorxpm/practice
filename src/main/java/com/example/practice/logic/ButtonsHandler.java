package com.example.practice.logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

public class ButtonsHandler {
    /**
     * @param login_field    принимает объект поля ввода логина
     * @param password_field принимает объект поля ввода пароля
     */
    public static List<String> getDataFromWidgetsAuthorization(TextField login_field, TextField password_field) {
        List<String> list_data = new ArrayList<>();
        list_data.add(login_field.getText());
        list_data.add(password_field.getText());
        return list_data;
    }
}
