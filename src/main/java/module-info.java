module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.testng;

    exports com.example.practice.test;
    exports com.example.practice.data.digest;
    exports com.example.practice.logic.exceptions;
    exports com.example.practice.data.bin;
    exports com.example.practice.logic;
    exports com.example.practice.windows;
    opens com.example.practice.windows to javafx.fxml;
    opens com.example.practice.logic to javafx.fxml;
}