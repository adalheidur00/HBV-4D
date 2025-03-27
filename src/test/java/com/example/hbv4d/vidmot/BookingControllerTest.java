package com.example.hbv4d.vidmot;

import com.example.hbv4d.vinnsla.Tour;
import com.example.hbv4d.vinnsla.User;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class BookingControllerTest {
    private BookingController bookingController;
    private Label tourNameLabel;
    private Label tourDateLabel;
    private Label tourDescriptionLabel;
    private ComboBox<String> monthSelect;
    private ComboBox<String> yearSelect;
    private Tour testTour;
    private User testUser;

    @BeforeEach
    void setUp() {
        tourNameLabel = new Label();
        tourDateLabel = new Label();
        tourDescriptionLabel = new Label();
        monthSelect = new ComboBox<>();
        yearSelect = new ComboBox<>();


        bookingController = new BookingController();
        bookingController.tourNameLabel = tourNameLabel;
        bookingController.tourDateLabel = tourDateLabel;
        bookingController.tourDescriptionLabel = tourDescriptionLabel;
        bookingController.monthSelect = monthSelect;
        bookingController.yearSelect = yearSelect;


        testTour = new Tour(1, "Scenic Mountain Hike", "A beautiful hike through the mountains.", 9000, LocalDate.parse("2025-05-20"), "Reykjavik", "10:00 AM", 20);
        bookingController.setTour(testTour);

        testUser = new User(1, "Test User", "testuser@example.com", "1234567");
        bookingController.user = testUser;
    }

    @AfterEach
    void teardown() {
        testTour = null;
        testUser = null;
    }

    @Test
    void testBookingControllerSetup() {
        assertNotNull(bookingController);
    }

    @Test
    void testUpdateUserInterface() {
        bookingController.updateUserInterface();

        assertEquals("Scenic Mountain Hike", tourNameLabel.getText());
        assertEquals("20.05.2025", tourDateLabel.getText());

        assertEquals(12, monthSelect.getItems().size());
        assertEquals(10, yearSelect.getItems().size());
    }

}
