package com.example.hbv4d;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IndexController {
    @FXML
    public Label fxLoggedIn;


    @FXML
    public void initialize(){
        String user = User.getLoggedIn();
        if (user != null) {
            fxLoggedIn.setText("User: " + user);
        }
    }
    /**
     * Færir user í browseTour senu
     * @throws Exception
     */
    @FXML
    public void onBrowseTours() throws Exception{
        Application.switchScene("tours-view.fxml");
    }

    @FXML
    public void onLogin() throws Exception{
        Application.switchScene("login-view.fxml");
    }

}
