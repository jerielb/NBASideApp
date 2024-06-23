package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.service.NewDraftPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewDraftPageController {
	private final Logger LOGGER = LogManager.getLogger(NewDraftPageController.class);
	private NewDraftPageService newDraftPageService;
	
	@Autowired
	public NewDraftPageController(NewDraftPageService newDraftPageService){
		this.newDraftPageService = newDraftPageService;
	}
	
	@PostMapping("/draft_page")
	public String getNewDraftPage(@RequestParam int league_size, @RequestParam int roster_size, Model model) {
		/* using @RequestParam to extract value from the [name=""] tag of the <select> tag inside the form from the html page */
		
		LOGGER.info("Reset draft page with League Size: " + league_size + " & Roster Size: " + roster_size);
		newDraftPageService.reset(league_size, roster_size);
		model.addAttribute("players", newDraftPageService.getDraftPool());
		model.addAttribute("team", newDraftPageService.getTeam());
		model.addAttribute("teamIndex", newDraftPageService.getTeamIndex()+1);
		
		LOGGER.info("Redirecting to Draft page");
		return "draft_page";
	}
	
	@PostMapping("/draft_page/draft_player")
	public String draftPlayer(@RequestParam int playerId, Model model) {
		LOGGER.debug("Drafted playerId: " + playerId + " for team: #" + newDraftPageService.getTeamIndex()+1);
		boolean fullTeam = newDraftPageService.draftPlayerToTeam(playerId);
		
		if (fullTeam) {
			LOGGER.info("Full roster drafted");
			LOGGER.info("Redirecting to Draft Summary page");
			return "redirect:/draft_summary_page";
		}
		
		model.addAttribute("players", newDraftPageService.getDraftPool());
		model.addAttribute("team", newDraftPageService.getTeam());
		model.addAttribute("teamIndex", newDraftPageService.getTeamIndex()+1);
		return "draft_page";
	}
	
	@GetMapping("/draft_summary_page")
	public String draftSummary(Model model) {
		model.addAttribute("leagueSize", newDraftPageService.getLeagueSize());
		model.addAttribute("team", newDraftPageService.getTeamAtIndex(0));
		model.addAttribute("loadPage", false);
		
		return "draft_summary_page";
	}
	
	@PostMapping("/draft_summary_page/team")
	public String draftSummaryTeam(@RequestParam int teamIndex, Model model) {
		LOGGER.debug("Get team in league index: " + teamIndex);
		
		model.addAttribute("leagueSize", newDraftPageService.getLeagueSize());
		model.addAttribute("team", newDraftPageService.getTeamAtIndex(teamIndex-1));
		model.addAttribute("loadPage", false);
		
		return "draft_summary_page";
	}
}
