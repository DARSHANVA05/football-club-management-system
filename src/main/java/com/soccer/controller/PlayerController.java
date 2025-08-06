package com.soccer.controller;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.auditing.CurrentDateTimeProvider;
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

import static org.slf4j.LoggerFactory.*;

@Controller
public class PlayerController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private CoachService coachService;
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/player-registration")
	public String showNewPlayerForm(Model model) {
		// create model attribute to bind form data
		Player player = new Player();
		model.addAttribute("player", player);
		return "new_player";
	}
	
	@PostMapping("/player/save")
	public String savePlayer(@ModelAttribute("player") Player player) {
		// save employee to database

		playerService.savePlayer(player);
		return "redirect:/";
	}
	
	@GetMapping("/player/update/{playerId}")
	public String showFormForUpdate(@PathVariable ( value = "playerId") long playerid, Model model) {
		
		// get player from the service
		Player player = playerService.getPlayerById(playerid);
		
		// set player as a model attribute to pre-populate the form
		model.addAttribute("player", player);
		return "update_player";
	}

	@GetMapping("/player/delete/{playerId}")
	public String deletePlayer(@PathVariable (value = "playerId") long playerid) {
		
		// call delete employee method 
		this.playerService.deletePlayerById(playerid);
		return "redirect:/";
	}

	private static final Logger logger = getLogger(PlayerController.class);


	@GetMapping("/player")
//	@Cacheable
	public String PlayerDetails(@RequestParam(required = true) long playerId, Model model) {

		logger.info("Start time: "+System.currentTimeMillis());
		Double start = (double) System.currentTimeMillis();

		Player player = playerService.getPlayerById(playerId);
		List<Coach> coaches = coachService.getCoachByClubId(player.getClubId());
		model.addAttribute("player", player);
		model.addAttribute("coaches", coaches);

		Double end = (double) System.currentTimeMillis();
		logger.info("End time: "+ System.currentTimeMillis());
		logger.info("Total time: "+ (end-start));

		return "player-details";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		Page<Player> page = playerService.findPaginated(pageNo, 5 , sortField, sortDir);
		List<Player> listplayer = page.getContent();
		 
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listPlayer", listplayer);

		
		Page<Coach> pageCoach = coachService.findPaginated(1, 3, sortField, sortDir);
		List<Coach> listcoach = pageCoach.getContent();
		
		model.addAttribute("currentPage_c", 1);
		model.addAttribute("totalPages_c", pageCoach.getTotalPages());
		model.addAttribute("totalItems_c", pageCoach.getTotalElements());
		model.addAttribute("sortField_c", sortField);
		model.addAttribute("sortDir_c", sortDir);
		model.addAttribute("reverseSortDir_c", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listCoach", listcoach);
		

		Page<Club> pageclub = clubService.findPaginated(1, 20 , "clubName", sortDir);
		List<Club> listclub = pageclub.getContent();
		
		model.addAttribute("currentPage_club", 1);
		model.addAttribute("totalPages_club", pageclub.getTotalPages());
		model.addAttribute("totalItems_club", pageclub.getTotalElements());
		model.addAttribute("sortField_club", "clubName");
		model.addAttribute("sortDir_club", sortDir);
		model.addAttribute("reverseSortDir_club", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listClub", listclub); 

		return "Index";
	}

}
