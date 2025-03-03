package com.example.hbv4d.vidmot;

import com.example.hbv4d.DataBase.UserDB;
import com.example.hbv4d.vinnsla.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";

    @FXML
    public TextField fxUsernameInput;

    @FXML
    public TextField fxPasswordInput;

    @FXML
    public void onLogin() throws IOException {
        String username = fxUsernameInput.getText();
        User loginUser = UserDB.getUser(username);
        if(loginUser == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("User not found");
            alert.show();
        }

        User.setLoggedIn(username);
        Application.switchScene(INDEX_PATH);
    }

    @FXML
    public void onBack() throws Exception {
        Application.switchScene(INDEX_PATH);
    }

}
