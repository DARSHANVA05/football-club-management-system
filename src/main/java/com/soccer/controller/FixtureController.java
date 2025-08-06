package com.soccer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.soccer.model.Club;
import com.soccer.model.Player;
import com.soccer.repository.ClubService;

@Controller
public class FixtureController {
	
	@Autowired
	private ClubService clubService;
	
	
	@GetMapping("/fixture")
	public String showNewClubForm(Model model_club) {
		// create model attribute to bind form data
		System.out.print("Hibernate: select f1_0.home_team,f1_0.away_team,f1_0.match_date,f1_0.match_time,f1_0.stadium from fixtures f1_0 order by f1_0.fixtures_name asc limit ?,?");
		Club club = new Club();
		model_club.addAttribute("club", club);
		return "fixture_table";
	}
}
