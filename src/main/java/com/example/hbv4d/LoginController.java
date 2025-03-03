package com.example.hbv4d;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    public TextField fxUsernameInput;

    @FXML
    public TextField fxPasswordInput;

    @FXML
    public void onLogin() throws IOException {
        String username = fxUsernameInput.getText();
        User.setLoggedIn(username);

        if(username == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("Username input empty");
            alert.show();
        }
        Application.switchScene("index-view.fxml");
    }

    @FXML
    public void onBack() throws Exception {
        Application.switchScene("index-view.fxml");
    }

}
