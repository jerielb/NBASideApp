package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.service.IndexService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final Logger LOGGER = LogManager.getLogger(IndexController.class);
    private IndexService indexService;
    
    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }
    
    @GetMapping("/logo")
    public String getHomePage() {
        LOGGER.info("Redirecting to Homepage");
        // redirects to default url with no extension
        return "redirect:/";
    }
    
    @GetMapping("/draft_option_page")
    public String getDraftTeamPage(Model model) {
		LOGGER.info("Redirecting to Draft Options page");
		return "draft_options_page";
    }
}
