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
public class CoachController {

	@Autowired
	private CoachService coachService;
	
	@Autowired 
	private PlayerService playerService;
	
	@Autowired
	private ClubService clubService;
	
	@GetMapping("/c")																//changed / to /c
	public String viewHomePage(Model model_c) {								//changed viewHomePage to viewCoachHomePage
		return findPaginated(1, "firstName", "asc", model_c);		
	}
	
	@GetMapping("/coach-registration")
	public String showNewCoachForm(Model model_c) {
		// create model attribute to bind form data
		Coach coach = new Coach();
		model_c.addAttribute("coach", coach);
		return "new_coach";
	}
	
	@PostMapping("/coach/save")
	public String saveCoach(@ModelAttribute("coach") Coach coach) {
		// save employee to database
		coachService.saveCoach(coach);
		return "redirect:/c";
	}
	
	@GetMapping("/coach/update/{coachId}")
	public String showFormForUpdateCoach(@PathVariable ( value = "coachId") long coachid, Model model_c) {

		Coach coach = coachService.getCoachById(coachid);
		model_c.addAttribute("coach", coach);
		return "update_coach";
	}
	
	@GetMapping("/coach/delete/{coachId}")
	public String deleteCoach(@PathVariable (value = "coachId") long coachid) {
		
		// call delete employee method 
		this.coachService.deleteCoachById(coachid);
		return "redirect:/c";
	}
	
	
	@GetMapping("/pagec/{pageNo}")													///page/{pageNo} to /pagec/{pageNo}
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField_c") String sortField,
			@RequestParam("sortDir_c") String sortDir,
			Model model) {

		
		Page<Coach> page = coachService.findPaginated(pageNo, 3 , sortField, sortDir);
		List<Coach> listcoach = page.getContent();
		
		model.addAttribute("currentPage_c", pageNo);
		model.addAttribute("totalPages_c", page.getTotalPages());
		model.addAttribute("totalItems_c", page.getTotalElements());
		model.addAttribute("sortField_c", sortField);
		model.addAttribute("sortDir_c", sortDir);
		model.addAttribute("reverseSortDir_c", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listCoach", listcoach);

		
		Page<Player> pagePlayer = playerService.findPaginated(1, 5 , sortField, sortDir);
		List<Player> listplayer = pagePlayer.getContent();
		
		model.addAttribute("currentPage", 1);
		model.addAttribute("totalPages", pagePlayer.getTotalPages());
		model.addAttribute("totalItems", pagePlayer.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listPlayer", listplayer);

		
		Page<Club> pageClub = clubService.findPaginated(1, 20 , "clubName", sortDir);
		List<Club> listclub = pageClub.getContent();
		
		model.addAttribute("currentPage_club", 1);
		model.addAttribute("totalPages_club", pageClub.getTotalPages());
		model.addAttribute("totalItems_club", pageClub.getTotalElements());
		model.addAttribute("sortField_club", "clubName");
		model.addAttribute("sortDir_club", sortDir);
		model.addAttribute("reverseSortDir_club", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listClub", listclub);
		
		return "Index";
	}
	
}
