package com.example.hbv4d;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ToursController {
    public Label fxLoggedIn;


    @FXML
    public void initialize(){
        String user = User.getLoggedIn();
        if (user != null) {
            fxLoggedIn.setText("User: " + user);
        }
    }
}
