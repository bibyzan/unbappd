package com.unbappd.enterprise;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        List<Review> reviews = this.reviewService.fetchAll();
        System.out.println(reviews);
        model.addAttribute(reviews);
        return "index";
    }

    /**
     * Handle the root of / endpoint and return index.html
     * @return
     */
    @RequestMapping("/createReview")
    public String createReview(Model model) {
        Review review = new Review();
        model.addAttribute(review);
        return "createReview";
    }

    @RequestMapping("/saveReview")
    public String saveReview(Review review, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            this.reviewService.save(review);
            this.reviewService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile, Model model) {
        String returnValue = "start";
        try {
            reviewService.saveImage(imageFile);
            Review review = new Review();
            model.addAttribute("img", review);
            returnValue = "image";
        }
        catch (IOException e) {
            e.printStackTrace();
            returnValue = "error";
        }
        System.out.println(returnValue);
        return "string";
    }
    @GetMapping("/reviews")
    @ResponseBody
    public List<Review> fetchAllReviews() {
        return this.reviewService.fetchAll();
    }
}
