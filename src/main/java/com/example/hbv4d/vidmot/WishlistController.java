package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.Tour;
import com.example.hbv4d.vinnsla.Wishlist;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class WishlistController {

    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";

    @FXML
    private ListView<Tour> wishlistListView;


    @FXML
    public void initialize() {
        wishlistListView.setItems(Wishlist.getWishlist());
    }

    @FXML
    public void onRemoveFromWishlist() {
        Tour selectedTour = wishlistListView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            Wishlist.removeTour(selectedTour);
        }
    }

    @FXML
    public void onBack() throws Exception {
        Application.switchScene(INDEX_PATH);
    }
}
