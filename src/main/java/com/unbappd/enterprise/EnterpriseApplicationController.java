package com.unbappd.enterprise;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EnterpriseApplicationController {
    @Autowired
    IReviewService reviewService;

    /**
     * Handle the root of / endpoint and return index.html
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Review review = new Review();
        model.addAttribute(review);
        return "index";
    }

    @RequestMapping("/saveReview")
    public String saveReview(Review review) {
        try {
            this.reviewService.save(review);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/reviews")
    @ResponseBody
    public List<Review> fetchAllReviews() {
        return this.reviewService.fetchAll();
    }
}
