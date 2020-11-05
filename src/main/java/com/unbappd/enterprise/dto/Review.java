package com.unbappd.enterprise.dto;
import lombok.Data;

public @Data
class Review {
    private int reviewId;
    private int placesId;
    private String reviewText;
    private int reviewScore;
    private double longitude;
    private double latitude;
    private double reviewerID;
}
