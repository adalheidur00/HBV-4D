package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IndexController {
    private static final String WISHLIST_PATH = "/com/example/hbv4d/wishlist-view.fxml";
    private static final String TOURS_PATH = "/com/example/hbv4d/tours-view.fxml";
    private static final String LOGIN_PATH = "/com/example/hbv4d/login-view.fxml";
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
        Application.switchScene(TOURS_PATH);
    }

    @FXML
    public void onLogin() throws Exception{
        Application.switchScene(LOGIN_PATH);
    }

    @FXML
    public void onWishList() throws Exception{
        Application.switchScene(WISHLIST_PATH);
    }

}
