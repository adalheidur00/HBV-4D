package com.example.hbv4d;

import java.time.LocalDate;

public class Tour {
        private final int tourId;
        private final String tourName;
        private final String description;
        private final int price;
        private final LocalDate date;
        private final String city;
        private final String schedule;
        //private final String availability;
        //private final String review;


        public Tour(int tourId, String tourName, String description, int price, LocalDate date, String city, String schedule) {
            this.tourId = tourId;
            this.tourName = tourName;
            this.description = description;
            this.price = price;
            this.date = date;
            this.city = city;
            this.schedule = schedule;
            //this.availability = availability;
            //this.review = review;
        }

        private int getId(){
            return tourId;
        }

        public LocalDate getDate(){
            return date;
        }

        public String getCity(){
            return city;
        }

        public String getTourName(){
            return tourName;
        }

        public String getDescription(){
            return description;
        }

        public int getPrice() {
            return price;
        }


        public String getSchedule(){
            return schedule;
        }

        /*
        private String getAvailability(){
            return availability;
        }

        private String listReviews(){
            return review;
        }
        */


    @Override
    public String toString() {
        return tourName + " - " + price + "kr - " + city + " - " + date;
    }
}
