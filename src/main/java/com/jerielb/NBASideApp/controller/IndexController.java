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
    // TODO: variables
    private final Logger LOGGER = LogManager.getLogger(IndexController.class);
    private IndexService indexService;
    
    // TODO: constructor
    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }
    
    // functions
    @GetMapping("/logo")
    public String getHomePage() {
        LOGGER.info("Redirecting to homepage");
        // redirects to default url with no extension
        return "redirect:/";
    }
    
    @GetMapping("/draft-page")
    public String getDraftTeamPage(Model model) {
        LOGGER.info("Redirecting to draft page");
        
        LOGGER.debug("Getting player draft pool from DB Player Table");
        model.addAttribute("players", indexService.getAllPlayers());
        return "draft-page";
    }
    
}
