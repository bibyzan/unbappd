package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dto.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *performs the methods for the service
 */

@Component
public class ReviewServiceStub implements IReviewService {


    public List<Review> reviewsDAO = new ArrayList<>();

    public ReviewServiceStub() {

    }

    @Override
    public void save(Review review) {
        reviewsDAO.add(review);
    }

    @Override
    public Review fetchById(int placeID) {
        Review review = new Review();
        review.setReviewText("A fabulous beer");
        review.setPlacesId(9);
        return review;
    }

}
