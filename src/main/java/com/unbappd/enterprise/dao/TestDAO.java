package com.unbappd.enterprise.dao;

import com.unbappd.enterprise.dto.Review;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

public interface TestDAO extends CrudRepository<Review, Integer> {
}
