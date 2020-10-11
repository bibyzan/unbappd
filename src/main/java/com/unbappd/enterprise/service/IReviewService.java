package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dto.Review;

import java.util.List;


/**
 * Declare the methods for the service
 */
public interface IReviewService {

    /**
     * Save a new Review
     * @param review the entry to save.
     */
    void save(Review review);

    /**
     * Return all review given a place.
     * @return a collection of reviews given a location.
     */
    List<Review> fetchById(Integer placeID);

}
