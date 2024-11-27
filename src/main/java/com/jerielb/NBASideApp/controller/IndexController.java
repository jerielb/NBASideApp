package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.model.enums.EastFranchise;
import com.jerielb.NBASideApp.model.enums.WestFranchise;
import com.jerielb.NBASideApp.service.IndexService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

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
    
    @GetMapping("/playoffs_options")
    public String getPlayoffsBracketPage(Model model) {
        LOGGER.info("Redirecting to Playoffs Bracket page");
        
        // playoffs options page
        model.addAttribute("westFranchisesTop", indexService.getWestTeamsTop());
        model.addAttribute("westFranchisesBottom", indexService.getWestTeamsBottom());
        model.addAttribute("eastFranchisesTop", indexService.getEastTeamsTop());
        model.addAttribute("eastFranchisesBottom", indexService.getEastTeamsBottom());

        return "playoffs_options";
    }
    
    @PostMapping("/playoffs_bracket")
    public String loadPlayoffBracket(@RequestParam String team, Model model) {
//	    LOGGER.info("Selected team: {}", team);
        
        // TODO: make customisable
        int playoffTeams = 16;
        boolean westTeamSelected = false;
        
        for (WestFranchise franchise: WestFranchise.values()) {
            if (franchise.toString().equals(team)) {
                model.addAttribute("westFranchises", indexService.getRandomWestTeams(playoffTeams, franchise));
                model.addAttribute("eastFranchises", indexService.getRandomEastTeams(playoffTeams, null));
                
                westTeamSelected = true;
                break;
            }
        }
        
        if (!westTeamSelected) {
            model.addAttribute("westFranchises", indexService.getRandomWestTeams(playoffTeams, null));
            model.addAttribute("eastFranchises", indexService.getRandomEastTeams(playoffTeams, 
                    Arrays.stream(EastFranchise.values()).filter(e -> e.toString().equals(team)).findFirst().get()));
        }
        
        return "playoffs_bracket";
    }
}
