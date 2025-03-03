package com.example.hbv4d;

import javafx.fxml.FXML;

public class WishlistController {

    @FXML
    public void onBack() throws Exception {
        Application.switchScene("index-view.fxml");
    }
}
