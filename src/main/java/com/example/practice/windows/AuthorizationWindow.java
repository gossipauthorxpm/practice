package com.example.practice.windows;

import com.example.practice.data.bin.Account;
import com.example.practice.data.bin.DataHandler;
import com.example.practice.data.digest.Hash;
import com.example.practice.logic.ButtonsHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author GOSSIPAUTHORXPM
 * @version 1.0
 */
public class AuthorizationWindow {

    @FXML
    protected Button authorization_button;
    @FXML
    private TextField login_field;
    @FXML
    private TextField password_field;

    @FXML
    protected void clickButtonAuthorize() throws SQLException {
//      Управление базой данных
        DataHandler database = new DataHandler();

//        Получение данных из полей ввода
        List<String> data_fields = ButtonsHandler.getDataFromWidgetsAuthorization(this.login_field, this.password_field);
        String login = data_fields.get(0).trim();
        String password = data_fields.get(1).trim();
//        Проверки на наличие введенных данных
        if (login.equals("") && password.equals("")) {
            new Alert(Alert.AlertType.INFORMATION, "Введите данные в поля для ввода!").show();
            return;
        }
        if (login.equals("")) {
            new Alert(Alert.AlertType.INFORMATION, "Введите данные в поле 'логин'!").show();
            return;
        }
        if (password.equals("")) {
            new Alert(Alert.AlertType.INFORMATION, "Введите данные в поле 'пароль'!").show();
            return;
        }
//      Получаем список всех аккаунтов
        List<Account> data_accounts = database.getAllDataTableAccount();

        String enter_login = this.login_field.getText().trim();
        String enter_password = this.password_field.getText().trim();

//      Получаем id из списка аккаунта если он присутсвует в системе
        int list_id_account = Account.getListIdAccount(data_accounts, enter_login);
        if (list_id_account == -1) {
            new Alert(Alert.AlertType.INFORMATION, "Аккаунт не существует!").show();
            return;
        }
        //      Если аккаун существует, проверяем к нему пароль
        String hash_enter_password = data_accounts.get(list_id_account).getPassword();
        if (!Hash.verifyHash(hash_enter_password, enter_password)) {
            new Alert(Alert.AlertType.INFORMATION, "Пароль введен не верно!\nПовторите попытку!").show();
            return;
        }
        if(data_accounts.get(list_id_account).getRole().equals("admin")){
            WindowHandler.startNewWindow("admin_panel.fxml", "Admin Panel", 600, 400);
        }

    }

}
