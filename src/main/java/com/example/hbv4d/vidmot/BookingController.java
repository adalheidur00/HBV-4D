package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.Tour;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class BookingController {
    private static final String TOURS_PATH = "/com/example/hbv4d/tours-view.fxml";
    public Label tourNameLabel;
    public Label tourDateLabel;
    public Label tourDescriptionLabel;
    public ComboBox monthSelect;
    public ComboBox yearSelect;
    private Tour tour;

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void updateUserInterface() {
        tourNameLabel.setText(tour.getTourName());
        tourDateLabel.setText(tour.getDate().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        monthSelect.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        yearSelect.getItems().addAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
    }


    public void onSubmit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Booking confirmation");
        alert.setHeaderText("Booking successful, click OK to return to the tour page");
        alert.show();
        alert.setOnCloseRequest(dialogEvent -> {
            try {
                Application.switchScene(TOURS_PATH);
                alert.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void onBack() {
        try {
           Application.switchScene(TOURS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
