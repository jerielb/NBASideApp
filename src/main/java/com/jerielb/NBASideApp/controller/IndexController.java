package com.jerielb.NBASideApp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // TODO: variables
    private final Logger LOGGER = LogManager.getLogger(IndexController.class);
    
    // TODO: constructor
    
    // functions
    @GetMapping("/logo")
    public String getHomePage() {
        LOGGER.info("Redirecting to homepage");
        // redirects to default url with no extension
        return "redirect:/";
    }
}
