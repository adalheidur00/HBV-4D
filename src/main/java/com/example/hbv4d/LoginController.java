package com.example.hbv4d;

import javafx.fxml.FXML;

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
        Application.switchScene("index-view.fxml");
    }

}
