package com.unbappd.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterpriseApplicationController {
    /**
     * Handle the root of / endpoint and return index.html
     * @return
     */
    @RequestMapping("/")
    public String index() {

        return "index";
    }
}
