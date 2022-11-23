package com.example.practice.data.bin;

import com.example.practice.data.digest.Hash;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<Account> getAllAccounts() throws SQLException {

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
    /**
     * Удаление аккаунта из базы данных по его идентификатору*/
    public void deleteAccount(int id_account) throws SQLException {
        String request = "DELETE FROM accounts WHERE id=" + Integer.toString(id_account) + ";";
        Connection database = getConnect();
        PreparedStatement result = database.prepareStatement(request); result.execute();
    }
    /**
     * Созадет аккаунт с указаными данными в табилице accounts*/
    public void createAccount(String id_account, String login, String password, String role, String status) throws SQLException{
        String hash_password = Hash.getHash(password);
        String request = "INSERT INTO accounts VALUES (" + id_account + ", "
                                                         + "'"+login+"'" + ", "
                                                         + "'"+hash_password+"'" + ", "
                                                         + "'"+status+"'" + ", "
                                                         + "'"+role+"'" + ");";
        Connection database = getConnect();
        PreparedStatement result = database.prepareStatement(request); result.execute();

    }
    public void updateAccount(String id, String role, String status) throws SQLException {
        String request = "UPDATE accounts SET status=" + "'" + status + "'" + "," + "role=" + "'" + role + "'" + "WHERE " +
                "id=" + id + ";";
        Connection database = getConnect();
        PreparedStatement result = database.prepareStatement(request); result.execute();
    }
}
