package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
