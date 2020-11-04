package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dao.ReviewsDAO;
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
    private ReviewsDAO reviewsDAO;


    public ReviewServiceStub() {

    }
    public ReviewServiceStub(ReviewsDAO reviewsDAO) {
        this.reviewsDAO = reviewsDAO;
    }

    @Override
    public void save(Review review) {

        reviewsDAO.save(review);
    }

    @Override
    public Review fetchById(int placeID) {
        Review review = new Review();
        review.setReviewText("A fabulous beer");
        review.setPlacesId(9);
        return review;
    }

}
