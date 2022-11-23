package com.example.practice.data.bin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler extends DataBase {
    /**
     * Получаем все данные из таблицы accounts.
     *
     * @author GOSSIPAUTHORXPM
     */
    public List<Account> getAllDataTableAccount() throws SQLException {

        List<Account> list = new ArrayList<>();
        String request = "SELECT * FROM accounts;";
        Connection database = getConnect();
        ResultSet result = database.createStatement().executeQuery(request);
        while (result.next()) {
            Account account = new Account(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
            list.add(account);
        }
        return list;
    }

    /**
     * Возвращает специальный список для заполнения таблицы админа*/
    public ObservableList<AccountTables> getAccountDataToAdminTable() throws SQLException {

        ObservableList<AccountTables> list = FXCollections.observableArrayList();
        String request = "SELECT * FROM accounts;";
        Connection database = getConnect();
        ResultSet result = database.createStatement().executeQuery(request);
        while (result.next()) {
            AccountTables account = new AccountTables(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
            list.add(account);
        }
        return list;
    }
}
