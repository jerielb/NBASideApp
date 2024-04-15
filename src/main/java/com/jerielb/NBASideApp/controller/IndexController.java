package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.service.DraftPageService;
import com.jerielb.NBASideApp.service.IndexService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    // TODO: variables
    private final Logger LOGGER = LogManager.getLogger(IndexController.class);
    private IndexService indexService;
	private DraftPageService draftPageService;
    
    // TODO: constructor
    @Autowired
    public IndexController(IndexService indexService, DraftPageService draftPageService) {
        this.indexService = indexService;
		this.draftPageService = draftPageService;
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
		LOGGER.debug("Reset draft page variables");
		List<Player> draftPool = indexService.getAllPlayers();
		draftPageService.reset(5, draftPool);
		model.addAttribute("players", draftPool);
		
		LOGGER.info("Redirecting to draft page");
		return "draft-page";
    }
    
}
