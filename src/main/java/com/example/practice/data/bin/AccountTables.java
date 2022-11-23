package com.example.practice.data.bin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

/**
 * @author GOSSIPAUTHORXPM
 * @version 1.0 beta
 * Класс рассширяет стандартный функционал класса Account и преобразует
 * данные для отправки в таблицу панели админа*/
public class AccountTables extends Account{

    private final SimpleIntegerProperty simple_id = new SimpleIntegerProperty(this.getId());
    private final SimpleStringProperty simple_login = new SimpleStringProperty(this.getLogin());
    private final SimpleStringProperty simple_password = new SimpleStringProperty(this.getPassword());
    private final SimpleStringProperty simple_status = new SimpleStringProperty(this.getStatus());
    private final SimpleStringProperty simple_role = new SimpleStringProperty(this.getRole());

    public AccountTables(int id, String login, String password, String status, String role) {
        super(id, login, password, status, role);
    }

    public int getSimple_id() {
        return simple_id.get();
    }

    public SimpleIntegerProperty simple_idProperty() {
        return simple_id;
    }

    public String getSimple_login() {
        return simple_login.get();
    }

    public SimpleStringProperty simple_loginProperty() {
        return simple_login;
    }

    public String getSimple_password() {
        return simple_password.get();
    }

    public SimpleStringProperty simple_passwordProperty() {
        return simple_password;
    }

    public String getSimple_status() {
        return simple_status.get();
    }

    public SimpleStringProperty simple_statusProperty() {
        return simple_status;
    }

    public String getSimple_role() {
        return simple_role.get();
    }

    public SimpleStringProperty simple_roleProperty() {
        return simple_role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
