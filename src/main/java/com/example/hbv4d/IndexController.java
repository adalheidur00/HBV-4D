package com.example.hbv4d;

import javafx.fxml.FXML;

public class IndexController {

    @FXML
    public void onBrowseTours() throws Exception{
        Application.switchScene("browseTour-view.fxml");
    }

    @FXML
    public void onLogin() throws Exception{
        Application.switchScene("login-view.fxml");
    }

}
