package com.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soccer.model.Club;
import com.soccer.model.Coach;
import com.soccer.model.Player;
import com.soccer.repository.CoachService;
import com.soccer.repository.PlayerService;
import com.soccer.repository.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private CoachService coachService;
	
	@Autowired
	private PlayerService playerService;
	
	
	@GetMapping("/club")																//changed / to /c
	public String viewHomePage(Model model_club) {								//changed viewHomePage to viewClubHomePage
		return findPaginated(1, "clubName", "asc", model_club);		
	}
	
	@GetMapping("/club-registration")
	public String showNewClubForm(Model model_club) {
		// create model attribute to bind form data
		Club club = new Club();
		model_club.addAttribute("club", club);
		return "new_club";
	}
	
	@PostMapping("/club/save")
	public String saveClub(@ModelAttribute("club") Club club) {
		// save employee to database
		clubService.saveClub(club);
		return "redirect:/c";
	}
	

	
	@GetMapping("/page_club/{pageNo}")													
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField_club") String sortField,
			@RequestParam("sortDir_club") String sortDir,
			Model model) {

		Page<Club> page = clubService.findPaginated(pageNo, 20 ,"clubName", sortDir);
		List<Club> listclub = page.getContent();
		
		model.addAttribute("currentPage_club", pageNo);
		model.addAttribute("totalPages_club", page.getTotalPages());
		model.addAttribute("totalItems_club", page.getTotalElements());
		model.addAttribute("sortField_club", "clubName");
		model.addAttribute("sortDir_club", sortDir);
		model.addAttribute("reverseSortDir_club", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listClub", listclub);

		
		Page<Coach> pageClub = coachService.findPaginated(1, 3 , sortField, sortDir);
		List<Coach> listcoach = pageClub.getContent();
		
		model.addAttribute("currentPage_c", 1);
		model.addAttribute("totalPages_c", pageClub.getTotalPages());
		model.addAttribute("totalItems_c", pageClub.getTotalElements());
		model.addAttribute("sortField_c", sortField);
		model.addAttribute("sortDir_c", sortDir);
		model.addAttribute("reverseSortDir_c", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listCoach", listcoach);

		
		Page<Player> pagePlayer = playerService.findPaginated(1, 3 , sortField, sortDir);
		List<Player> listplayer = pagePlayer.getContent();
		
		model.addAttribute("currentPage", 1);
		model.addAttribute("totalPages", pagePlayer.getTotalPages());
		model.addAttribute("totalItems", pagePlayer.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listPlayer", listplayer);

		return "Index";
	}
	
}
