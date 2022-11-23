package com.example.practice.data.bin;

import javafx.stage.Stage;

public class StaticData {
    public static Stage getAuthorizationWindow() {
        return authorization_window;
    }

    public static void setAuthorizationWindow(Stage authorization_window) {
        StaticData.authorization_window = authorization_window;
    }

    private static Stage authorization_window;

}
