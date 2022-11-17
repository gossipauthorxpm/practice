package com.example.practice.windows;

import com.example.practice.logic.ButtonsHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;


public class AuthorizationWindow {

    @FXML
    protected Button authorization_button;
    @FXML
    private TextField login_field;
    @FXML
    private TextField password_field;
    @FXML
    protected void clickButtonAuthorize() {

        List<String> data_fields = ButtonsHandler.getDataFromWidgetsAuthorization(this.login_field, this.password_field);
        String login = data_fields.get(0).trim();
        String password = data_fields.get(1).trim();
        if(login.equals("") && password.equals("")) {
            new Alert(Alert.AlertType.INFORMATION, "Введите в поля для ввода!").show();return;
        }
        if(login.equals("")){
            new Alert(Alert.AlertType.INFORMATION, "Введите данные в поле 'логин'!").show();return;
        }
        if(password.equals("")){
            new Alert(Alert.AlertType.INFORMATION, "Введите данные в поле 'пароль'!").show();return;
        }

    }
}
