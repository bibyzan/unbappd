package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class ReviewSQLDAO implements IReviewDAO {
//    @Autowired
//    ReviewRepository reviewRepository;
    @Autowired
    TestDAO testDAO;

    @Override
    public Review save(Review review) throws Exception {
        return testDAO.save(review);//reviewRepository.save(review);
    }

    @Override
    public Review fetchById(int placeID) {
        return null;
    }
}
