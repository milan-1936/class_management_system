package com.example.studentdashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Dashboard extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource("hello-view.fxml"));
        TabPane container = new TabPane();
        Scene scene = new Scene(fxmlLoader.load(), 1080, 700);
        stage.setTitle("Class Management System");
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sclLogo.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setMinWidth(1080);
        stage.setMinHeight(700);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}