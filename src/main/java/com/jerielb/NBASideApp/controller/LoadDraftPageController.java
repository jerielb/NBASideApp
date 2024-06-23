package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.service.LoadDraftPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoadDraftPageController {
	public static final Logger LOGGER = LogManager.getLogger(LoadDraftPageController.class);
	private LoadDraftPageService loadDraftPageService;
	
	@Autowired
	public LoadDraftPageController(LoadDraftPageService loadDraftPageService) {
		this.loadDraftPageService = loadDraftPageService;
	}
	
	@GetMapping("/draft_summary_page/{id}")
	public String getNewDraftPage(@PathVariable("id") int league_id, Model model) {
		League league = loadDraftPageService.getLeagueId(league_id);
		
		model.addAttribute("leagueSize", loadDraftPageService.getLeagueSize());
		model.addAttribute("team", league.getTeams().get(0));
		model.addAttribute("league_id", league_id);
		model.addAttribute("loadPage", true);
		
		return "draft_summary_page";
	}
	
	@PostMapping("/draft_summary_page/{id}/team")
	public String draftSummaryTeam(@PathVariable("id") int league_id, @RequestParam int teamIndex, Model model) {
		LOGGER.debug("Get team in league index: " + teamIndex);
		
		model.addAttribute("leagueSize", loadDraftPageService.getLeagueSize());
		model.addAttribute("team", loadDraftPageService.getTeamAtIndex(teamIndex-1));
		model.addAttribute("league_id", league_id);
		model.addAttribute("loadPage", true);
		
		return "draft_summary_page";
	}
}
