package com.example.hbv4d;

import java.time.LocalDate;

public class Tour {
        private final int id;
        private final String tourName;
        private final String description;
        private final int price;
        private final LocalDate date;
        private final String city;
        private final String schedule;
        private final String availability;
        private final String review;


        public Tour(int id, String tourName, String description, int price, LocalDate date, String city, String schedule, String availability, String review) {
            this.id = id;
            this.tourName = tourName;
            this.description = description;
            this.price = price;
            this.date = date;
            this.city = city;
            this.schedule = schedule;
            this.availability = availability;
            this.review = review;
        }

        private LocalDate getDate(){
            return date;
        }

        private String getCity(){
            return city;
        }

        private String getSchedule(){
            return schedule;
        }

        private String getTourName(){
            return tourName;
        }

        private String getDescription(){
            return description;
        }

        private String getAvailability(){
            return availability;
        }

        private String listReviews(){
            return review;
        }
}
