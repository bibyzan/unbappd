package com.unbappd.enterprise.dto;
import lombok.Data;

public @Data
class Review {
    private int reviewId;
    private int placesId;
    private String reviewText;
    private int reviewScore;
}