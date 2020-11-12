package com.unbappd.enterprise.service;

import com.unbappd.enterprise.DAO.ReviewDAO;
import com.unbappd.enterprise.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *performs the methods for the service
 */

@Component
public class ReviewServiceStub implements IReviewService {

    @Autowired
    private ReviewDAO reviewDAO;

    public List<Review> reviewsDAO = new ArrayList<>();

    public ReviewServiceStub() {

    }

    @Override
    public Review save(Review review) throws Exception {
        return reviewDAO.save(review);
    }

    @Override
    public Review fetchById(int placeID) {
        Review review = new Review();
        review.setReviewText("A fabulous beer");
        review.setPlacesId(9);
        return review;
    }

}
