package com.unbappd.enterprise;

import com.unbappd.enterprise.dto.Review;
import com.unbappd.enterprise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterpriseApplicationController {
    /**
     * Handle the root of / endpoint and return index.html
     * @return
     */
    @Autowired
    IReviewService reviewService;

    @RequestMapping("/")
    public String index() {

        return "index";

    }



}
