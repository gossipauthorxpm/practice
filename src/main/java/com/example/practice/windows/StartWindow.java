package com.example.practice.windows;

import com.example.practice.data.bin.StaticData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("authorization_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 950, 665);
        stage.setTitle("Practice");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}