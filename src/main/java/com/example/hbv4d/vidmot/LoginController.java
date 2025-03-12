package com.example.hbv4d.vidmot;

import com.example.hbv4d.utils.InfoDialog;
import com.example.hbv4d.vinnsla.User;
import com.example.hbv4d.vinnsla.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller for logging a user in
 */
public class LoginController {
    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";

    @FXML
    public TextField fxUsernameInput;

    @FXML
    public TextField fxPasswordInput;

    /**
     * Logs a user in
     * Goes back to index scene when user is logged in
     */
    @FXML
    public void onLogin() throws IOException {
        String username = fxUsernameInput.getText();
        User user = UserDAO.getUser(username);
        if(user == null){
            InfoDialog alert = new InfoDialog("Login failed","User not found");
            alert.show();
        }

        User.setLoggedIn(user);
        Application.switchScene(INDEX_PATH);
    }

    /**
     * Go back to index scene
     */
    @FXML
    public void onBack() throws Exception {
        Application.switchScene(INDEX_PATH);
    }

}
