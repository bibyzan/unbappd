package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewSQLDAO implements IReviewDAO {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) throws Exception {
        return this.reviewRepository.save(review);
    }

    @Override
    public void cheers(int reviewId) {
        Review review = this.fetchById(reviewId);
        review.setCheers(review.getCheers() + 1);
        this.reviewRepository.save(review);
    }

    @Override
    public Review fetchById(int placeID) {
        return this.reviewRepository.findById(placeID).get();
    }

    @Override
    public List<Review> fetchAll() {
        ArrayList<Review> reviews = new ArrayList<>();
        for (Review rev: this.reviewRepository.findAll()) {
            reviews.add(rev);
        }
        return reviews;
    }
}
