package com.example.hbv4d.vidmot;

import com.example.hbv4d.utils.InfoDialog;
import com.example.hbv4d.vinnsla.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for browsing tours.
 * User can browser tours and see tour reviews
 * Logged-in user can browse tours, add tours to wishlist, see reviews and book a tour.
 */
public class ToursController {

    private static final String INDEX_PATH = "/com/example/hbv4d/index-view.fxml";
    private static final String BOOKING_PATH = "/com/example/hbv4d/booking-view.fxml";

    public Label fxLoggedIn;
    public TextField searchBar;


    public ListView<Tour> tourList = new ListView<>();
    @FXML
    private ComboBox<String> priceFilter;
    @FXML
    private ComboBox<String> cityFilter;
    @FXML
    private DatePicker dateFilter;

    public AnchorPane infoPane;
    public Text descriptionText;
    public Text scheduleText;
    public Label descriptionTitle;
    public Label dateLabel;

    @FXML
    private Button fxWishlistButton;
    @FXML
    private Button fxBookingButton;
    @FXML
    private Button fxSeeReviewsButton;

    private FilteredList<Tour> filteredTours;

    /**
     * Initializes the controller
     * Adds tours from Database to and ObservableList
     * Adds tours from the ObservableList to a filtered list for filtering
     * Enables buttons for logged-in User
     */
    @FXML
    public void initialize(){
        ObservableList<Tour> tours = TourDAO.listTours();
        if (tours != null) {
            for (Tour tour : tours) {
                tourList.getItems().add(tour);
            }
        }

        filteredTours = new FilteredList<>(tours, p -> true);
        tourList.setItems(filteredTours);

        searchBar.textProperty().addListener((obs, oldValue, newValue) -> applyFilters());
        priceFilter.valueProperty().addListener((obs, oldValue, newValue) -> applyFilters());
        cityFilter.valueProperty().addListener((obs, oldValue, newValue) -> applyFilters());
        dateFilter.valueProperty().addListener((obs, oldValue, newValue) -> applyFilters());

        String user = User.getLoggedIn();
        if (user != null) {
            fxLoggedIn.setText("User: " + user);
            fxBookingButton.setDisable(false);
            fxWishlistButton.setDisable(false);
        } else {
            fxBookingButton.setDisable(true);
            fxWishlistButton.setDisable(true);
        }
    }

    /**
     * Helper function for getting all information for a selected tour
     * @param tour Selected tour from the ObservableList
     */
    private void getTourInformation(Tour tour){
        descriptionTitle.setText(tour.getTourName());
        dateLabel.setText(tour.getDate().toString().formatted("%d/%m/%Y"));
        descriptionText.setText(tour.getDescription());
        scheduleText.setText(tour.getSchedule());
        if (infoPane.isVisible()) {
            return;
        }
        infoPane.setVisible(true);
    }

    /**
     * Helper function to switch scenes to booking scene
     * @param tour Selected tour from ObservableList
     */
    public void switchScene(Tour tour) throws IOException {
        Stage stage = (Stage) searchBar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(BOOKING_PATH));

        Parent root =  fxmlLoader.load();
        Scene scene = new Scene(root);

        BookingController controller = fxmlLoader.getController();
        controller.setTour(tour);
        controller.updateUserInterface();

        stage.setScene(scene);
        stage.setTitle("Booking");
        stage.show();
    }

    /**
     * Switches scenes to booking scene if a tour is selected and Book button is pressed
     */
    public void onBookTour() {
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }
        try {
            switchScene(selectedTour);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets all information for selected tour
     */
    public void onClickedTour(){
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if(selectedTour == null){
            return;
        }
        getTourInformation(selectedTour);
    }

    /**
     *  See reviews for selected tour
     */
    public void onSeeReviews() {
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }

        List<Review> reviews = ReviewDAO.getReviewsForTour(selectedTour.getId());

        InfoDialog alert = new InfoDialog("Tour Reviews","Reviews for " + selectedTour.getTourName());

        if (reviews.isEmpty()) {
            alert.setContentText("No reviews available for this tour.");
        } else {
            StringBuilder reviewText = new StringBuilder();
            for (Review review : reviews) {
                reviewText.append("Rating ").append(review.getRating()).append("/5 - ")
                        .append(review.getFirstName()).append("\n")
                        .append("\"").append(review.getComment()).append("\"\n\n");
            }
            alert.setContentText(reviewText.toString());
        }

        alert.showAndWait();
    }

    /**
     * Adds selected tour to wishlist
     */
    public void onAddToWishlist() {
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            Wishlist.addTour(selectedTour);
        }

        assert selectedTour != null;
        InfoDialog alert = new InfoDialog("Added to Wishlist","Tour Added Successfully!");
        alert.setContentText(selectedTour.getTourName() + " has been added to your wishlist.");
        alert.showAndWait();
    }


    /**
     * Applies filters
     */
    private void applyFilters() {
        String searchText = searchBar.getText().toLowerCase();
        String selectedPrice = priceFilter.getValue();
        String selectedCity = cityFilter.getValue();
        LocalDate selectedDate = dateFilter.getValue();

        filteredTours.setPredicate(tour -> {
            if (!searchText.isEmpty()) {
                if (!tour.getTourName().toLowerCase().contains(searchText)) {
                    return false;
                }
            }

            if (selectedPrice != null) {
                switch (selectedPrice) {
                    case "Under 10,000kr":
                        if (tour.getPrice() >= 10000) return false;
                        break;
                    case "Under 20,000kr":
                        if (tour.getPrice() >= 20000) return false;
                        break;
                    case "Under 30,000kr":
                        if (tour.getPrice() >= 30000) return false;
                        break;
                    case "Under 40,000kr":
                        if (tour.getPrice() >= 40000) return false;
                        break;
                }
            }

            if (selectedCity != null && !selectedCity.equals("All Cities")) {
                if (!tour.getCity().equalsIgnoreCase(selectedCity)) {
                    return false;
                }
            }

            if (selectedDate != null) {
                if (!tour.getDate().equals(selectedDate)) {
                    return false;
                }
            }
            return true;
        });
    }

    @FXML
    public void onBack() throws Exception {
        Application.switchScene(INDEX_PATH);
    }

}
