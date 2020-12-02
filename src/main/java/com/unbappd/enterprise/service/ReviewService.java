package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dao.IReviewDAO;
import com.unbappd.enterprise.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *performs the methods for the service
 */

@Service
public class ReviewService implements IReviewService {
    @Autowired
    public IReviewDAO reviewDAO;

    @Override
    public Review save(Review review) throws Exception {
        reviewDAO.save(review);
        return review;
    }

    @Override
    public Review fetchById(int placeID) {
        return reviewDAO.fetchById(placeID);
    }

    @Override
    public List<Review> fetchAll() {
        return reviewDAO.fetchAll();
    }

}
