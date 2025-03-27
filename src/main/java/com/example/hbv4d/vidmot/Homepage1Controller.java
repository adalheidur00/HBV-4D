package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Homepage1Controller {

    private static final String TOURS_PATH = "/com/example/hbv4d/tours-view.fxml";
    private static final String LOGIN_PATH = "/com/example/hbv4d/login-view.fxml";

    @FXML
    public Label fxLoggedIn;
    @FXML
    private Button loginButton;
    @FXML
    private Button browseTourButton;

    /**
     * Initializes the controller if a user is logged in
     */
    @FXML
    public void initialize(){
        User user = User.getLoggedIn();
        if (user != null) {
            fxLoggedIn.setText("Welcome " + user.getName());
        } else {
            fxLoggedIn.setText(" ");
        }
    }

    @FXML
    public void onLogin() throws Exception {
        Application.switchScene(LOGIN_PATH);
    }

    @FXML
    public void onBrowseTours() throws Exception {
        Application.switchScene(TOURS_PATH);
    }
}
