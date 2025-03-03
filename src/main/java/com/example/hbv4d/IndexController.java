package com.example.hbv4d;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IndexController {
    @FXML
    public Label fxLoggedIn;

    @FXML
    private Button fxWishlistButton;

    @FXML
    public void initialize(){
        String user = User.getLoggedIn();
        if (user != null) {
            fxLoggedIn.setText("User: " + user);
            fxWishlistButton.setDisable(false);
        } else {
            fxWishlistButton.setDisable(true);
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

    @FXML
    public void onWishList() throws Exception{
        Application.switchScene("wishlist-view.fxml");
    }

}
