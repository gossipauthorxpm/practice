package com.example.practice.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowHandler {
    public static void startNewWindow(String name_loader, String title, int width, int height){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource(name_loader));
            Scene scene = new Scene(fxmlLoader.load(), width, height);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException error) {
            System.out.println("Не удалось создать новое окно!n" + error.toString());
        }
    }
}
