package com.example.practice.data.bin;

import javafx.stage.Stage;

public class StaticData {
    static public Integer FATAL_LOGIN_LENGTH = 32;
    static public Integer FATAL_PASSWORD_LENGTH = 32;
    static public Integer FATAL_ROLE_LENGTH = 5;
    static public Integer FATAL_STATUS_LENGTH = 8;
    private static Stage AUTHORIZATION_WINDOW;
    private static Stage ADMIN_WINDOW;

    public static Stage getAdminWindow() {
        return ADMIN_WINDOW;
    }

    public static void setAdminWindow(Stage adminWindow) {
        ADMIN_WINDOW = adminWindow;
    }

    public static Stage getAuthorizationWindow() {
        return AUTHORIZATION_WINDOW;
    }

    public static void setAuthorizationWindow(Stage authorization_window) {
        StaticData.AUTHORIZATION_WINDOW = authorization_window;
    }



}
