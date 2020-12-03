package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class ReviewDAOStub implements IReviewDAO {
    List<Review> reviews = new ArrayList<>();

    @Override
    public Review save(Review review) throws Exception {
        this.reviews.add(review);
        return review;
    }

    @Override
    public void cheers(int reviewId) {
        Review review = this.fetchById(reviewId);
        review.setCheers(review.getCheers() + 1);
        for (Review r: reviews)
            if (r.getId().equals(review.getId()))
                r.setCheers(review.getCheers());
    }

    @Override
    public Review fetchById(int placeID) {
        for (Review r: reviews)
            if (r.getId() == placeID)
                return r;
        return null;
    }

    @Override
    public List<Review> fetchAll() {
        return reviews;
    }
}
