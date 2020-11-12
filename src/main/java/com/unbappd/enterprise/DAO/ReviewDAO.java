package com.unbappd.enterprise.DAO;

import com.unbappd.enterprise.dto.Review;

import java.util.List;

public interface ReviewDAO {
    Review save(Review review) throws Exception;

    List<Review> fetchAll();
}
