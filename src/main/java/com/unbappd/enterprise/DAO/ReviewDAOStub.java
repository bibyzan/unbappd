package com.unbappd.enterprise.DAO;

import com.unbappd.enterprise.dto.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewDAOStub implements ReviewDAO {

    List<Review> allReviews = new ArrayList<Review>();

    @Override
    public Review save(Review review) throws Exception {
        return null;
    }

    @Override
    public List<Review> fetchAll() {
        return null;
    }
}
