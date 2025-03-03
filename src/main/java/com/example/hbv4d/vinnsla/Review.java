package com.example.hbv4d.vinnsla;

public class Review {
    private final String reviewerName;
    private final String reviewContent;
    private final int rating;

    public Review(String reviewerName, String reviewContent, int rating) {
        this.reviewerName = reviewerName;
        this.reviewContent = reviewContent;
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review by " + reviewerName + ": " + reviewContent + " (Rating: " + rating + ")";
    }
}
