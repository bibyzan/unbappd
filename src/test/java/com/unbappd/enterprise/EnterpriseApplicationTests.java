package com.unbappd.enterprise;

import com.unbappd.enterprise.dao.IReviewDAO;
import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    IReviewService reviewService;
    private Review review;

    @MockBean
    private IReviewDAO reviewDAO;

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
        reviewEntry.setId(0);
        reviewEntry.setPlaceId("0");
        reviewEntry.setScore(5);
        reviewEntry.setLat(51.1232);
        reviewEntry.setLng(51.1232);
        reviewEntry.setText(reviewTxt);
        reviewEntry.setReviewerName("101");

        assertEquals(reviewTxt, reviewEntry.getText());
        assertEquals(reviewScr, reviewEntry.getScore());
    }

    private void givenReviewDataAreAvailable() {
        String reviewTxt = "Really Good Beer";
        Integer reviewScr = 5;

        Review reviewEntry = new Review();
        reviewEntry.setId(9);
        reviewEntry.setPlaceId("9");
        reviewEntry.setScore(9);
        reviewEntry.setLat(51.1232);
        reviewEntry.setLng(51.1232);
        reviewEntry.setText(reviewTxt);
        reviewEntry.setReviewerName("101");
        try {
            reviewDAO.save(review);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void whenUserSearchesWithPlaceID9(){
        review = reviewDAO.fetchById(9);

    }
    private void thenReturnReviewsWithPlaceID9(){
        String returnedReviewText = review.getText();
        String checkPlacesID = review.getPlaceId();
        assertEquals("A fabulous beer", returnedReviewText);
        assertEquals("9",checkPlacesID);
    }

    @Test
    void saveNewReview_validateNewReviewByReturningReviewText() {
        givenReviewDataAreAvailable();
        whenUserSearchesWithPlaceID9();
        thenReturnReviewsWithPlaceID9();
    }
}
