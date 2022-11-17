package com.example.practice.data.bin;

import java.util.List;

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

    public static int getListIdAccount(List<Account> accounts, String hash_login) {
        for (int item = 0; item < accounts.size(); item++) {
            if (hash_login.equals(accounts.get(item).getLogin())) {
                return item;
            }
        }
        return -1;
    }
}
