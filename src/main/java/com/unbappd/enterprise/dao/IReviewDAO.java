package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;

public interface IReviewDAO {
    /**
     * Save a new Review
     * @param review the entry to save.
     */
    Review save(Review review) throws Exception;

    /**
     * Return all review given a place.
     * @return a collection of reviews given a location.
     */

    Review fetchById(int placeID);

}
