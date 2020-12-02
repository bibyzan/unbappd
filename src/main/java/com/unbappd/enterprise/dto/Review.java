package com.unbappd.enterprise.dto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data
class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String placeId;
    private String placeName;
    private String productName;
    private String text;
    private int score;
    private double lng;
    private double lat;
    private String reviewerName;
}
