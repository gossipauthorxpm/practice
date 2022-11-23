package com.example.practice.test;

import com.example.practice.data.bin.Account;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AccountTest {

    @Test
    public void testGetListIdAccount() {
        Account account1 = new Account(1, "gossipauthorxpm", "5412321", "no_limit", "admin");
        Account account2 = new Account(2, "gossi", "5412321", "no_limit", "admin");
        Account account3 = new Account(3, "gossipau", "5412321", "no_limit", "admin");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);accounts.add(account2);accounts.add(account3);

        assertEquals(1, Account.getListIdAccount(accounts, "gossi"));
        assertEquals(0, Account.getListIdAccount(accounts, "gossipauthorxpm"));
        assertEquals(-1, Account.getListIdAccount(accounts, "654654654"));
    }
}