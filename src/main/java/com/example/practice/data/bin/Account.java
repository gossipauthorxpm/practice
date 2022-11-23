package com.example.practice.data.bin;

import java.util.List;

/**
 * @author GOSSIPAUTHORXPM
 * @version 1.0
 * Класс служит для хранения данных из базы данных, таблица Accounts
 */
public class Account {
    private int id;
    private String login;
    private String password;
    private String status;
    private String role;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public Account(int id, String login, String password, String status, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    /**
     * @param accounts   принимает список List с Object = Account
     * @param login принимает строку с login
     *                   Возвращает index элемента логина из списка аккаутов, принятых в базе данных.
     *                   Если аккаунт не найден, возвращает -1
     */
    public static int getListIdAccount(List<Account> accounts, String login) {
        for (int item = 0; item < accounts.size(); item++) {
            if (login.equals(accounts.get(item).getLogin())) {
                return item;
            }
        }
        return -1;
    }
}
