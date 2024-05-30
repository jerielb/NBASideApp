package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.service.DraftPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DraftPageController {
	private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
	private DraftPageService draftPageService;
	
	@Autowired
	public DraftPageController(DraftPageService draftPageService){
		this.draftPageService = draftPageService;
	}
	
	@PostMapping("/draft_page")
	public String getNewDraftPage(@RequestParam int league_size, @RequestParam int roster_size, Model model) {
		// using @RequestParam to extract value from the [name=""] tag of the <select> tag inside the form from the html page
		
		LOGGER.info("Reset draft page with League Size: " + league_size + " & Roster Size: " + roster_size);
		draftPageService.reset(league_size, roster_size);
		model.addAttribute("players", draftPageService.getDraftPool());
		model.addAttribute("team", draftPageService.getTeam());
		
		LOGGER.info("Redirecting to Draft page");
		return "draft_page";
	}
	
	@PostMapping("/draft_page/draft_player")
	public String draftPlayer(@RequestParam int playerId, Model model) {
		LOGGER.debug("Drafted playerId: " + playerId + " for team in league index: " + draftPageService.getTeamIndex());
		boolean fullTeam = draftPageService.draftPlayerToTeam(playerId);
		
		if (fullTeam) {
			LOGGER.info("Full roster drafted");
			LOGGER.info("Redirecting to Draft Summary page");
			return "redirect:/draft_summary_page";
		}
		
		model.addAttribute("players", draftPageService.getDraftPool());
		model.addAttribute("team", draftPageService.getTeam());
		return "draft_page";
	}
	
	@GetMapping("/draft_summary_page")
	public String draftSummary(Model model) {
		model.addAttribute("leagueSize", draftPageService.getLeagueSize());
		model.addAttribute("team", draftPageService.getTeamAtIndex(0));
		
		return "draft_summary_page";
	}
	
	@PostMapping("/draft_summary_page/team")
	public String draftSummaryTeam(@RequestParam int teamIndex, Model model) {
		LOGGER.debug("Get team in league index: " + teamIndex);
		
		model.addAttribute("leagueSize", draftPageService.getLeagueSize());
		model.addAttribute("team", draftPageService.getTeamAtIndex(teamIndex-1));
		
		return "draft_summary_page";
	}
}
