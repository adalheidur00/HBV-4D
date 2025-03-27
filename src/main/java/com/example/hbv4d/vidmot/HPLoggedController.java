package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HPLoggedController {

    private static final String TOURS_PATH = "/com/example/hbv4d/tours-view.fxml";
    private static final String BOOKINGS_PATH = "/com/example/hbv4d/mBooking-view.fxml";
    private static final String WISHLIST_PATH = "/com/example/hbv4d/wishlist-view.fxml";
    private static final String REVIEWS_PATH = "/com/example/hbv4d/review-view.fxml";

    @FXML
    public Label fxLoggedIn;

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
    public void onBrowseTours() throws Exception {
        Application.switchScene(TOURS_PATH);
    }

    @FXML
    public void onManageBookings() throws Exception {
        Application.switchScene(BOOKINGS_PATH);
    }

    @FXML
    public void onWishlist() throws Exception {
        Application.switchScene(WISHLIST_PATH);
    }

    @FXML
    public void onReviews() throws Exception {
        Application.switchScene(REVIEWS_PATH);
    }
}
