package com.example.hbv4d.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Stage primaryStage;
    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        switchScene(INDEX_PATH);
    }



    public static void switchScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}

