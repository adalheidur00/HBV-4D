package com.example.hbv4d.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class Application extends javafx.application.Application {
    private static Stage primaryStage;
    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        switchScene(INDEX_PATH);
        dbConn();
    }

    public void dbConn() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());

        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
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

