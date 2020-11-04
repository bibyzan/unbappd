package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewsDAOStub implements ReviewsDAO {

    public List<Review> reviewsList = new ArrayList<>();

    @Override
    public void save(Review review) {
        reviewsList.add(review);
    }
}
