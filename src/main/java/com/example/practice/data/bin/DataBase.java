package com.example.practice.data.bin;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class DataBase {
    String root_name = "root";
    String password = "1488";

    /**
     * Подключение к базе данных MySQL
     */
    protected Connection getConnect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/airport", root_name, password);
        } catch (SQLException error) {
            new Alert(Alert.AlertType.ERROR, "Ошибка подключения к базе данных!");
            return null;
        }
    }
}
