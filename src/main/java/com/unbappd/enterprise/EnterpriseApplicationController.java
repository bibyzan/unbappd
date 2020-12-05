package com.unbappd.enterprise;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class EnterpriseApplicationController {
    @Autowired
    IReviewService reviewService;

    /**
     * Handle the root of / endpoint and return index.html
     *
     * @return
     */
    @RequestMapping("/")
    public String index(@RequestParam(value = "searchTerm", required = false, defaultValue = "None") String searchTerm, Model model) {
        List<Review> reviews = this.reviewService.fetchAll();
        if (!searchTerm.equals("None")) {
            List<Review> filteredReviews = new ArrayList<>();
            for (Review review : reviews)
                if (review.getPlaceId().equals(searchTerm))
                    filteredReviews.add(review);
            reviews = filteredReviews;
        }
        System.out.println(reviews);
        model.addAttribute(reviews);
        return "index";
    }

    /**
     * Handle the root of / endpoint and return index.html
     *
     * @return
     */
    @RequestMapping("/createReview")
    public String createReview(Model model) {
        Review review = new Review();
        model.addAttribute(review);
        return "createReview";
    }

    @RequestMapping("/saveReview")
    public String saveReview(Review review, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        try {
            review.setPicExt(imageFile.getContentType().substring(6, imageFile.getContentType().length()));
            this.reviewService.save(review);
            this.reviewService.saveImage(imageFile, review.getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // EnterpriseApplication.restart();
        List<Review> reviews = this.reviewService.fetchAll();
        System.out.println(reviews);
        model.addAttribute(reviews);
        return "index";
    }

    @GetMapping("/reviews")
    @ResponseBody
    public List<Review> fetchAllReviews() {
        return this.reviewService.fetchAll();
    }


    @RequestMapping("/cheers")
    public String cheers(@RequestParam(value = "id") String id, Model model) {
        this.reviewService.cheers(Integer.parseInt(id));
        List<Review> reviews = this.reviewService.fetchAll();
        System.out.println(reviews);
        model.addAttribute(reviews);
        return "index";
    }

    @RequestMapping("/reviewDetails")
    public String reviewDetails(@RequestParam(value = "id") String id, Model model) {
        System.out.println(id);
        Review review = this.reviewService.fetchById(Integer.parseInt(id));
        model.addAttribute(review);
        System.out.println(review);
        return "reviewDetails";
    }
}
