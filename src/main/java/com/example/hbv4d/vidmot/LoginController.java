package com.example.hbv4d.vidmot;

import javafx.scene.control.*;

public class LoginController {

    public Label fxLoggedIn;
    public TextField fxUsernameInput;
    public TextField fxPasswordInput;

    public void onLogin(){
        String username = fxUsernameInput.getText();
        fxLoggedIn.setText("Logged in as: " + username);
    }


}
