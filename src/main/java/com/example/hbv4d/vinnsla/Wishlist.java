package com.example.hbv4d.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Wishlist {
    private static final ObservableList<Tour> wishlist = FXCollections.observableArrayList();

    public static ObservableList<Tour> getWishlist() {
        return wishlist;
    }

    public static void addTour(Tour tour) {
        if (!wishlist.contains(tour)) {
            wishlist.add(tour);
        }
    }

    public static void removeTour(Tour tour) {
        wishlist.remove(tour);
    }
}
