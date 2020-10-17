package com.unbappd.enterprise;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    IReviewService reviewService;

    @Test
    void contextLoads() {
    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void verifyReviewProperties() {
        String reviewTxt = "Really Good Beer";
        Integer reviewScr = 5;

        Review reviewEntry = new Review();
        reviewEntry.setReviewId(0);
        reviewEntry.setPlacesId(0);
        reviewEntry.setReviewScore(5);
        reviewEntry.setReviewText(reviewTxt);

        assertEquals(reviewTxt, reviewEntry.getReviewText());
        assertEquals(reviewScr, reviewEntry.getReviewScore());
    }
}
