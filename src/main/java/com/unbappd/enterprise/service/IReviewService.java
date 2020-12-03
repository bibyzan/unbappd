package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dto.Review;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * Declare the methods for the service
 */
public interface IReviewService {

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

    List<Review> fetchAll();

    void saveImage(MultipartFile imageFile) throws IOException;
}
