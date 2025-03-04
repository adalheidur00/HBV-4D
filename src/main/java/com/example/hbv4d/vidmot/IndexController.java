package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controller for index page
 * User can browse tours and login
 * Only a user that is logged in can see his/her wishlist
 */
public class IndexController {
    private static final String WISHLIST_PATH = "/com/example/hbv4d/wishlist-view.fxml";
    private static final String TOURS_PATH = "/com/example/hbv4d/tours-view.fxml";
    private static final String LOGIN_PATH = "/com/example/hbv4d/login-view.fxml";
    @FXML
    public Label fxLoggedIn;

    @FXML
    private Button fxWishlistButton;

    /**
     * Initializes the controller if a user is logged in
     */
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
     * Switches scenes to browse tour scene
     */
    @FXML
    public void onBrowseTours() throws Exception{
        Application.switchScene(TOURS_PATH);
    }

    /**
     * Switches scenes to login scene
     */
    @FXML
    public void onLogin() throws Exception{
        Application.switchScene(LOGIN_PATH);
    }

    /**
     * Switches scenes to wishlist scene
     * ONLY possible if user is logged in
     */

    @FXML
    public void onWishList() throws Exception{
        Application.switchScene(WISHLIST_PATH);
    }

}
