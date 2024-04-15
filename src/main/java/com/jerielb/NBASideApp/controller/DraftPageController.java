package com.jerielb.NBASideApp.controller;

import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.service.DraftPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DraftPageController {
	// variables
	private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
	private DraftPageService draftPageService;
	
	// constructor
	@Autowired
	public DraftPageController(DraftPageService draftPageService){
		this.draftPageService = draftPageService;
	}
	
	// functions
	@PostMapping("/draft-player")
	public String draftPlayer(@RequestParam int playerId, Model model) {
		LOGGER.info("Drafted playerId: " + playerId);
		
//		boolean fullTeam = draftPageService.draftPlayerToTeam(player);
		model.addAttribute("players", draftPageService.getDraftPool());
		
//		if (fullTeam) {
//			return "draft-summary";
//		} else {
			return "draft-page";
//		}
	}
}
