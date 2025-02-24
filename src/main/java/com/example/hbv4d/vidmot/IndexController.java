package com.example.hbv4d.vidmot;

import javafx.fxml.FXML;

public class IndexController {

    /**
     * Færir user í browseTour senu
     * @throws Exception
     */
    @FXML
    public void onBrowseTours() throws Exception{
        Application.switchScene("/com/example/hbv4d/browseTour-view.fxml");
    }

    @FXML
    public void onLogin() throws Exception{
        Application.switchScene("/com/example/hbv4d/login-view.fxml");
    }

}
