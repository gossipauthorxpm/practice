package com.example.practice.test;

import com.example.practice.logic.exceptions.UserException;
import com.example.practice.windows.AdminPanel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AdminPanelTest extends AdminPanel {

    @Test
    public void testCheckLongWordsFields() {
        assertThrows(UserException.class, () -> {
            this.checkLongWordsFields("fsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsd", "1234", "1234", "1234");
        });
    }

    @Test
    public void testCheckLongWordsFieldsTwo() {
        assertThrows(UserException.class, () -> {
            this.checkLongWordsFields("1234", "fsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfs5", "1234", "1234");
        });
    }

    @Test
    public void testTestCheckEmptyFields() {
        assertThrows(UserException.class, () -> {
            this.checkEmptyFields("321321", "", "321", "321", "432");
        });
        assertThrows(UserException.class, () -> {
            this.checkEmptyFields("321321", "fsdfsd", "321", "");
        });
    }
}