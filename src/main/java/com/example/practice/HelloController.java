package com.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label authorization_label;
    @FXML
    private Button authorization_button;
    @FXML
    protected void onHelloButtonClick() {
        authorization_label.setText("Welcome to JavaFX Application!");
    }
}